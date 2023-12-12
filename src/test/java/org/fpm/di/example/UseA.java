package org.fpm.di.example;

import javax.inject.Inject;

public class UseA {
    private final A dependency;
    private final B b;


    @Inject
    public UseA(A a, B b) {
        this.dependency = a;
        this.b = b;

    }

    public A getDependency() {
        return dependency;
    }
    public B getB() {
        return b;
    }


}
