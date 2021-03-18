package com.jinm.pattern.singleton.lazy;

public class SingletonLazyInnerClass {

    private SingletonLazyInnerClass(){

    }

    public static SingletonLazyInnerClass getInstance(){
        return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        private static final SingletonLazyInnerClass instance = new SingletonLazyInnerClass();
    }

}
