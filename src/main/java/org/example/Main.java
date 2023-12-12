package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//
//        // Створюємо об'єкт контейнера
//        OurContainer container = new OurContainer(new HashMap<>(), new HashMap<>());
//
//        // Прив'язуємо ArrayList до самого себе
//        container.bind(ArrayList.class);
//
//        // Отримуємо компонент типу ArrayList
//        ArrayList<?> arr = container.getComponent(ArrayList.class);
//
//        // Виводимо розмір отриманого ArrayList
//        System.out.println(arr.size());





//        OurContainer x = new OurContainer();
//        x.bind(ArrayList.class);
//        ArrayList arr = x.getComponent(ArrayList.class);
//        OurContainer y = new OurContainer(x);
//        System.out.println(y.getComponent(OurContainer.class));


//        // Створюємо об'єкт x
//        OurContainer x = new OurContainer();
//        // Прив'язуємо ArrayList до самого себе
//        x.bind(ArrayList.class);
//        // Отримуємо компонент типу ArrayList
//        ArrayList arr = x.getComponent(ArrayList.class);
//
//        // Реєструємо OurContainer в контейнері x
//        x.bind(OurContainer.class, OurContainer.class);
//
//        // Створюємо новий об'єкт y на основі існуючого об'єкта x
//        OurContainer y = new OurContainer(x);
//
//        // Тепер y має такий самий стан, як x
//        // Отримуємо компонент типу OurContainer в контейнері y
//        OurContainer ourContainerInY = y.getComponent(OurContainer.class);
//        System.out.println(ourContainerInY);
//
//

        // Створюємо об'єкт x
        OurContainer x = new OurContainer();
        // Прив'язуємо MySingleton до самого себе
        x.bind(x.getClass());  // Замість MySingleton.class використовуємо x.getClass()

        // Створюємо об'єкт y на основі існуючого об'єкта x
        OurContainer y = new OurContainer(x);

        // Отримуємо компонент MySingleton в об'єктах x та y
        OurContainer singletonInX = x.getComponent(x.getClass());  // Замість MySingleton.class використовуємо x.getClass()
        OurContainer singletonInY = y.getComponent(y.getClass());  // Замість MySingleton.class використовуємо x.getClass()

        // Виводимо хеш-коди об'єктів
        System.out.println("Хеш-код OurContainer в x: " + System.identityHashCode(singletonInX));
        System.out.println("Хеш-код OurContainer в y: " + System.identityHashCode(singletonInY));



//        Map<Class<?>, List<Class<?>>> components = new HashMap<>();
//        TreeSet <String> tree = new TreeSet<>();


        //створюємо екземпляр класу OurContainer
//        OurContainer ourContainer = new OurContainer();
//        ourContainer.printConstructors(OurContainer.class);
//
//
//        List<String> hierarchy = ourContainer.printSubClassesInterfaces(OurContainer.class);
//
//        System.out.println(hierarchy);
//        // Виводимо результат в консоль
//        for (String line : hierarchy) {
//            System.out.println(line);
//        }



    }
}


//public class Main {
//    public static void main(String[] args) {
//        // Get the Class object for MyClass
//        Class<?> myClass = MyClass.class;
//
//        try {
//            // Create an instance using newInstance method (deprecated in Java 9)
//            MyClass myObject = (MyClass) myClass.newInstance();
//            System.out.println("Object created using newInstance: " + myObject);
//
//            // Create an instance using getDeclaredConstructor and newInstance
//            MyClass anotherObject = (MyClass) myClass.getDeclaredConstructor().newInstance();
//            System.out.println("Object created using getDeclaredConstructor: " + anotherObject);
//        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//}