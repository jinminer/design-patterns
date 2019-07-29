package com.jinm.learning.design.pattern.creational.singleton.serializable;

import java.io.Serializable;

/**
 * hungry singleton.
 * Created by jinm on  2019/07/29.  contact: keanemer.gmail.com
 */

public class HungrySingleton implements Serializable {

    private HungrySingleton(){

    }

    private static final HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }

}
