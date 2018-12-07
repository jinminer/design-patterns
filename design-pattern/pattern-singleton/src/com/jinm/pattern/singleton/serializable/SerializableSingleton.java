package com.jinm.pattern.singleton.serializable;

import java.io.Serializable;

/**
 * Created by jinm on  2018/10/29.
 */

public class SerializableSingleton implements Serializable {

    private static final SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton(){

    }

    public static SerializableSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }

}
