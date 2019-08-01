package com.jinm.learning.design.pattern.creational.singleton.container;

/**
 * test thread.
 * Created by jinm on  2019/08/01.  contact: keanemer.gmail.com
 */

public class T implements Runnable {

    @Override
    public void run() {

        ContainerSingleton.putInstance("object", new Object());
        Object instance = ContainerSingleton.getInstance("object");
        System.out.println(Thread.currentThread().getName() + "-" + instance);

    }

}
