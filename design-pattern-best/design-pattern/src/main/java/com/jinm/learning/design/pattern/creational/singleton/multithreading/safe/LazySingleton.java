package com.jinm.learning.design.pattern.creational.singleton.multithreading.safe;

/**
 * lazy singleton.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class LazySingleton {

    public static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

/*    public static synchronized LazySingleton getInstance(){

        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;

    }*/

    public static LazySingleton getInstance(){

        synchronized(LazySingleton.class){
            if (lazySingleton == null){
                lazySingleton = new LazySingleton();
            }
        }

        return lazySingleton;

    }



}
