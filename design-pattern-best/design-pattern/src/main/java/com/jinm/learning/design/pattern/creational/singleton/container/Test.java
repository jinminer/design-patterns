package com.jinm.learning.design.pattern.creational.singleton.container;

/**
 * test.
 * Created by jinm on  2019/08/01.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end ......");

    }

}
