package com.jinm.pattern.singleton.test;

import com.jinm.pattern.singleton.lazy.LazyOne;
import com.jinm.pattern.singleton.lazy.LazyThree;
import com.jinm.pattern.singleton.lazy.LazyTwo;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jinm on  2018/10/25.
 */

public class LazyThreadSafeTest {

    public static void main(String[] args) {

        //lazy synchronized     使用CountDownLatch实现高并发
        //test1();

        //lazy no synchronized     使用CountDownLatch实现高并发
        //test2();

        //lazy synchronized      no  CountDownLatch
        //test3();

        //lazy no CountDownLatch
        //test4();

        //lazy
        test5();

    }

    private static void test1(){
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);

        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {

            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                        Object object = LazyTwo.getInstance();
                        System.out.println(System.currentTimeMillis() + ":" + object);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();

            latch.countDown();
        }

        Long end = System.currentTimeMillis();
        System.out.println("总耗时" + (end - start));
    }

    private static void test2(){
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);

        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {

            new Thread(){
                @Override
                public void run() {
                    try {
                        latch.await();
                        Object object = LazyTwo.getInstance();
                        System.out.println(System.currentTimeMillis() + ":" + object);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();

            latch.countDown();
        }

        Long end = System.currentTimeMillis();
        System.out.println("总耗时" + (end - start));
    }

    private static void test3() {
        int count = 100000;
        Long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            Object object = LazyOne.getInstance();
            System.out.println(System.currentTimeMillis() + ":" + object);
        }

        Long end = System.currentTimeMillis();
        System.out.println("总耗时" + (end - start));

    }

    private static void test4() {
        int count = 100000;
        Long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            Object object = LazyTwo.getInstance();
            System.out.println(System.currentTimeMillis() + ":" + object);
        }

        Long end = System.currentTimeMillis();
        System.out.println("总耗时" + (end - start));

    }

    private static void test5() {
        int count = 200;
        Long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            Object object = LazyThree.getInstance();
            System.out.println(System.currentTimeMillis() + ":" + object);
        }

        Long end = System.currentTimeMillis();
        System.out.println("总耗时" + (end - start));
    }

}
