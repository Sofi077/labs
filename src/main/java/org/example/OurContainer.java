package org.example;

import org.fpm.di.Binder;
import org.fpm.di.Container;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;;
import java.util.*;
public class OurContainer implements Binder, Container{
    private final Map<Class<?>, Class<?>> clasMap;
    private final Map<Class<?>, Object> instancMap;


    public OurContainer() {
        this.clasMap = new HashMap<>();
        this.instancMap = new HashMap<>();
    }
    public OurContainer(OurContainer other) {
        this.clasMap = new HashMap<>(other.clasMap);
        this.instancMap = new HashMap<>(other.instancMap);
    }
    public OurContainer(Map<Class<?>, Class<?>> clasMap, Map<Class<?>, Object> instancMap) {
        this.clasMap = clasMap;
        this.instancMap = instancMap;
    }

    @Override
    public <T> void bind(Class<T> clazz) { //прив'язуємо клас до самого себе
        if (clazz == null) {
            throw new ExeptionE("Зв'язування з null неможливе");
        }
        bind(clazz, clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        if (clasMap.containsKey(clazz) || instancMap.containsKey(clazz)) {
            throw new ExeptionE("Прив'язування неможливе. Клас %s вже прив'язаний".formatted(clazz));
        }

        clasMap.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        //тобто instance має бути екземпляром класу clazz
        if (clasMap.containsKey(clazz) || instancMap.containsKey(clazz)) {
            throw new ExeptionE("Прив'язування неможливе. Клас %s вже прив'язаний".formatted(clazz));
        }
        instancMap.put(clazz, instance);
    }


    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (instancMap.containsKey(clazz)) {
            return (T) instancMap.get(clazz);
        }
        if (clasMap.containsKey(clazz)) {
            Class<T> requestedClass = (Class<T>) clasMap.get(clazz);
            if (!requestedClass.equals(clazz) && (clasMap.containsKey(requestedClass) || instancMap.containsKey(requestedClass))) {
                return getComponent(requestedClass);  //якщо є прив'язка
            }
            return getInstance(requestedClass);  //і якщо нема
        }
        else {
            List<Class<? extends T>> implementations = getStored(clazz);
            if (implementations.isEmpty()) {
                throw new ExeptionE("Незареєстрований клас: %s".formatted(clazz));
            }

            return getComponent(implementations.get(0));
        }
    }

    private <T> T getInstance(Class<T> clazz) {
        T instance = null;
        try {
            instance = getInstanceInjectConstructor(clazz);
            if (instance == null) {
                instance = getInstanceConstructor(clazz);
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new ExeptionE("Не вдалося створити екземпляр класу %s".formatted(clazz));
        }
        return instance;
    }

    private <T> T getInstanceInjectConstructor(Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getAnnotation(Inject.class) != null) {
                Class<?>[] params = constructor.getParameterTypes();
                Object[] args = new Object[params.length];
                for (int i = 0; i < params.length; i++) {
                    args[i] = getComponent(params[i]);
                }
                constructor.setAccessible(true);
                T instance = (T) constructor.newInstance(args);
                if (clazz.getAnnotation(Singleton.class) != null) {
                    instancMap.put(clazz, instance);
                }
                return instance;
            }
        }
        return null;
    }

    private <T> T getInstanceConstructor(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T instance = constructor.newInstance();
        if (clazz.getAnnotation(Singleton.class) != null) {
            instancMap.put(clazz, instance);
        }
        return instance;
    }

    private <T> List<Class<? extends T>> getStored(Class<T> clazz) {  //для отримання списку реалізацій
        List<Class<? extends T>> implementations = new ArrayList<>();

        for (Class<?> key : clasMap.keySet()) {
            Class<?> superClass = key;

            while (!superClass.equals(Object.class)) {
                if (superClass.equals(clazz)) {
                    implementations.add((Class<? extends T>) key);
                }
                superClass = superClass.getSuperclass();
            }
        }
        return implementations;
    }


    public List<Constructor<?>> printConstructors(Class<?> clazz) {
        List<Constructor<?>> constructorsList = new ArrayList<>();

        Constructor<?>[] constructors = clazz.getConstructors();  //масив із конструкторами
        for (Constructor<?> constructor : constructors) {


            //додаємо кожен конструктор до constructorsList
            constructor.setAccessible(true);  //для отримання доступу до непублічних конструкторів
            constructorsList.add(constructor);


            System.out.println("Constructor: " + constructor.getName());
            printParametrsConstuctor(constructor);  //отримуємо параметри

        }
        return constructorsList;
    }
    public List<String> printParametrsConstuctor(Constructor constructor){
        List<String> parametersList = new ArrayList<>();

        //для параметрів конструктора
        Class<?>[] paramTypes = constructor.getParameterTypes();
        System.out.println("Parameters:");
        for (Class<?> paramType : paramTypes) {
            parametersList.add(paramType.getName());
            //System.out.print(paramType.getName() + " ");
            System.out.print(paramType.getSimpleName() + " ");
        }

        System.out.println("\n");
        return parametersList;
    }


    public List<String> printSubClassesInterfaces(Class<?> clazz){
        List<String> hierarchyList = new ArrayList<>();  //для зберігання імен класів і інтерфейсів
        //тут викликаємо метод передаючи клас, попередній список в якому ієрархія
        printHierarchy(clazz, hierarchyList, 0);
        return hierarchyList;
    }

    private static void printHierarchy(Class<?> clazz, List<String> hierarchyList, int depth) {
        //пробіли для форматування виводу
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  ");
        }

        //додаємо до списку поточний клас чи інтерфейс з відступом
        hierarchyList.add(indentation.toString() + clazz.getName());

        //виводимо інтерфейси
        Class<?>[] interfaces = clazz.getInterfaces();  //отримуємо інтерфейс
        for (Class<?> anInterface : interfaces) {
            //для кожного інтерфейсу рекурсивно викликається printHierarchy
            //для виведення ієрархії цього інтерфейсу збільшеною на одиницю глибиною
            printHierarchy(anInterface, hierarchyList, depth + 1);
        }

        //так само виводимо батьківські класи
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            printHierarchy(superclass, hierarchyList, depth + 1);
        }
    }
}
