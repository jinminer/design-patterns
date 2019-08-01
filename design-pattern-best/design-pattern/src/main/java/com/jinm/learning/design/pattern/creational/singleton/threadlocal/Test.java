package com.jinm.learning.design.pattern.creational.singleton.threadlocal;

/**
 * test.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "-" + instance);
        }

        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end ......");

    }

}
