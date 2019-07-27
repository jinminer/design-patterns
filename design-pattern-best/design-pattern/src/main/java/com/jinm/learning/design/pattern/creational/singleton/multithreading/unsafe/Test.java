package com.jinm.learning.design.pattern.creational.singleton.multithreading.unsafe;

/**
 * test.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("process end");

    }

}
