package org.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.Environment;

import java.util.HashMap;
import java.util.Map;

public class Configur implements Environment {
    @Override
    public Container configure(Configuration configuration) {
        Map<Class<?>, Class<?>> clasMap = new HashMap<>();
        Map<Class<?>, Object> instancMap = new HashMap<>();
        Binder binder = new OurContainer(clasMap, instancMap);
        Container container = new OurContainer(clasMap, instancMap);
        configuration.configure(binder);  //робимо прив'язку
        return container;
    }
}
