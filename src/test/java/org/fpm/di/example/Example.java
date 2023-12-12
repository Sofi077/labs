package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Before;
import org.junit.Test;
import org.example.Configur;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new Configur();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
//        final UseA hasADependency = container.getComponent(UseA.class);
//        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
//        UseA hasADependency = container.getComponent(UseA.class);

        B b = container.getComponent(B.class);
        B b2 = container.getComponent(B.class);
        System.out.println(b);
        System.out.println(b2);
        A a = container.getComponent(A.class);
        A a2 = container.getComponent(A.class);
        System.out.println(a);
        System.out.println(a2);


        UseA hasADependency = container.getComponent(UseA.class);
        System.out.println(hasADependency);

    }

}
