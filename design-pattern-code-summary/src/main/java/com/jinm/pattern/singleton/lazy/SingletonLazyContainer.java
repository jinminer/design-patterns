package com.jinm.pattern.singleton.lazy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonLazyContainer {

    private static final Map<String, SingletonLazyContainer> container= new ConcurrentHashMap<>();

    private SingletonLazyContainer(){

    }

    public static SingletonLazyContainer getInstance(String className){

        if (!container.containsKey(className)){
            synchronized (SingletonLazyContainer.container){
                if (!container.containsKey(className)){
                    container.put(className, new SingletonLazyContainer());
                }
            }
        }

        return container.get(className);

    }

}
