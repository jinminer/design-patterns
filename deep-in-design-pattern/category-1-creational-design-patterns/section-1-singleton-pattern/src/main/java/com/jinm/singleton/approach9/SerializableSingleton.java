package com.jinm.singleton.approach9;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private SerializableSingleton(){

    }

    private static class SingletonHelper{
        private static final SerializableSingleton INSTANCE = new SerializableSingleton();
    }

    public static SerializableSingleton getInstance(){
        return SerializableSingleton.SingletonHelper.INSTANCE;
    }

    protected Object readResolve(){
        return getInstance();
    }

}
