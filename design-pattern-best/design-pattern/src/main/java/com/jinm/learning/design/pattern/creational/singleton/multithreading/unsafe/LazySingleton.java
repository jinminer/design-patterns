package com.jinm.learning.design.pattern.creational.singleton.multithreading.unsafe;

/**
 * lazy singleton.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class LazySingleton {

    public static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

    /**
     *  线程不安全
     */
    public static LazySingleton getInstance(){

        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;

    }

}
