package com.jinm.pattern.singleton.lazy;

public class SingletonLazyVolatile {

    private static volatile SingletonLazyVolatile instance;

    private SingletonLazyVolatile(){

    }

    public static SingletonLazyVolatile getInstance(){

        if (instance == null){
            synchronized (SingletonLazyDoubleCheck.class) {
                if (instance  == null) {
                    instance = new SingletonLazyVolatile();
                }
            }
        }
        return instance;

    }

}
