package com.jinm.pattern.singleton.hungry;

public class SingletonThreadLocal {

    private static final ThreadLocal<SingletonThreadLocal> locals = new ThreadLocal<SingletonThreadLocal>(){
        @Override
        protected SingletonThreadLocal initialValue() {
            return new SingletonThreadLocal();
        }
    };

    private SingletonThreadLocal(){

    }

    public static SingletonThreadLocal getInstance(){
        return locals.get();
    }

}
