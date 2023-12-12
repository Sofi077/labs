package org.example;

import org.example2.Apple;
import org.example2.Pear;
import org.example2.SingletonAplle;
import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.A;
import org.fpm.di.example.B;
import org.fpm.di.example.MyPrototype;
import org.fpm.di.example.MySingleton;
import org.junit.Before;
import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Test;
import org.example.Configur;

import java.net.BindException;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
public class Test1 {
    OurContainer container = new OurContainer();
    @Test
    public void Singleton() {
        OurContainer pico2 = new OurContainer();
        pico2.bind(SingletonAplle.class);
        SingletonAplle a3 = pico2.getComponent(SingletonAplle.class);
        SingletonAplle a4 = pico2.getComponent(SingletonAplle.class); // обидва ті самі екземпляри
        assertSame(a3, a4);
    }
    @Test
    public void notSingleton() {
        OurContainer pico1 = new OurContainer();
        pico1.bind(Apple.class);
        Apple a1 = pico1.getComponent(Apple.class);
        Apple a2 = pico1.getComponent(Apple.class);
        assertNotSame(a1, a2);
    }

    @Test
    public void test3() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        //прив'язка класу до його реалізації
        OurContainer binder = new OurContainer();
        binder.bind(Apple.class, Pear.class);
        binder.bind(Pear.class, new Pear());

        //коли буде викликано метод getComponent(Apple.class) в контейнері,
        //буде повернуто екземпляр Pear,
        //оскільки клас Apple має залежність від класу Pear

        Apple e1 = binder.getComponent(Apple.class);
        Pear e2 = binder.getComponent(Pear.class);
        final Pear bAsSingleton = binder.getComponent(Pear.class);
        assertSame(e1, bAsSingleton);
        assertSame(e2, bAsSingleton);
        assertSame(e1, e2);
    }
    @Test
    public void bindToInstance() {
        OurContainer binder = new OurContainer();

        //екземпляр Apple
        Apple appleInstance = new Apple();

        //прив'язуємо клас Apple до конкретного екземпляра
        binder.bind(Apple.class, appleInstance);

        Apple result = binder.getComponent(Apple.class);
        assertSame(appleInstance, result);
    }

    @Test
    public void bindToInterface() {
        OurContainer binder = new OurContainer();

        //реалізація інтерфейсу Peelable
        Peelable peelableInstance = new org.example.Apple();

        //прив'язуємо інтерфейс Peelable до конкретної реалізації
        binder.bind(Peelable.class, peelableInstance);

        Peelable result = binder.getComponent(Peelable.class);
        assertSame(peelableInstance, result);
    }

}
