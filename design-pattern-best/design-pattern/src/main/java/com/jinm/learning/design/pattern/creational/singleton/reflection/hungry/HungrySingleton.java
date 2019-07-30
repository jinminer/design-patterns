package com.jinm.learning.design.pattern.creational.singleton.reflection.hungry;

import java.io.Serializable;

/**
 * hungry singleton.
 * Created by jinm on  2019/07/29.  contact: keanemer.gmail.com
 */

public class HungrySingleton implements Serializable {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){

        /**
         *  防止反射攻击
         */
        if (instance != null){
            throw new RuntimeException("单例构造器，禁止反射");
        }
    }

    public static HungrySingleton getInstance(){
        return instance;
    }

}
