package com.jinm.pattern.singleton.lazy;

public class SingletonLazyDoubleCheck {

    private static SingletonLazyDoubleCheck instance;

    private SingletonLazyDoubleCheck(){

    }

    public static SingletonLazyDoubleCheck getInstance(){

        if (instance == null){
            synchronized (SingletonLazyDoubleCheck.class) {
                if (instance  == null) {
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return instance;

    }

}
