package com.jinm.pattern.singleton.hungry;

import java.io.Serializable;

public class SingletonHungrySerialize implements Serializable {

    private static final SingletonHungrySerialize instance = new SingletonHungrySerialize();

    private SingletonHungrySerialize(){
    }

    public static SingletonHungrySerialize getInstance(){
        return instance;
    }


    public Object readResolve(){
        if (instance != null){
            return instance;
        }
        return null;
    }

}
