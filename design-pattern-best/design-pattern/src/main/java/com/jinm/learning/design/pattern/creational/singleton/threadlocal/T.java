package com.jinm.learning.design.pattern.creational.singleton.threadlocal;

/**
 * thread.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class T implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "-" + instance);
        }

    }
}
