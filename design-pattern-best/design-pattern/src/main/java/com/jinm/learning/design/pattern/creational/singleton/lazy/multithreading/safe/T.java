package com.jinm.learning.design.pattern.creational.singleton.lazy.multithreading.safe;

/**
 * thread.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class T implements Runnable {

    @Override
    public void run() {

        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "-" + lazySingleton);

    }

}
