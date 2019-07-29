package com.jinm.learning.design.pattern.creational.singleton.lazy.multithreading.safe;

/**
 * lazy singleton.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class LazySingleton {

    public static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }
    /* 这两种加锁方式，写法不同，作用相同 */
    /*    public static LazySingleton getInstance(){

        synchronized(LazySingleton.class){
            if (lazySingleton == null){
                lazySingleton = new LazySingleton();
            }
        }

        return lazySingleton;

    }*/

    /**
     *  绝对线程安全，性能较低
     *  方法加锁，当某个线程持有方法的执行权限时，
     *  在该线程执行完方法之前，其他线程都会阻塞
     */
    public static synchronized LazySingleton getInstance(){

        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;

    }

}
