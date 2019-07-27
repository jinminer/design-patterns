package com.jinm.learning.design.pattern.creational.singleton.multithreading.safe.doublecheck;

/**
 * lazy singleton double check.
 * Created by jinm on  2019/07/28.  contact: keanemer.gmail.com
 */

public class LazySingletonDoubleCheck {

    public static LazySingletonDoubleCheck instance = null;

    private LazySingletonDoubleCheck(){

    }

    /**
     *  双重检查锁：提高程序性能，并确保只有一个线程来完成对象创建操作
     *      添加双重判断逻辑：
     *          内层加锁的同步判断逻辑保证多线程场景下，对象实例创建的单例性，解决线程安全问题；
     *          外层判断逻辑，确保在对象已经创建成功的情况下，线程不去执行加锁的同步代码，提高程序性能
     *  问题：指令重排
     */
    public static LazySingletonDoubleCheck getInstance(){

        if (instance == null){
            synchronized (LazySingletonDoubleCheck.class){
                if (instance == null){
                    instance = new LazySingletonDoubleCheck();

                    /**
                     *  java语言规范：所有线程在执行程序时必须遵守 intra-thread-semantics 规定：
                     *      保证重排序不会改变单线程内的程序运行结果
                     *  程序指令排序：
                     *      提高程序的执行性能
                     *
                     */

                    //1.分配内存给LazySingletonDoubleCheck对象

                    //3.对instance变量进行赋值(这一可能会在2之前执行)

                    //2.初始化LazySingletonDoubleCheck对象
                    //------3.对instance变量进行赋值：将1中分配的内存指针(句柄)赋值给instance变量

                }
            }
        }

        return instance;

    }

}
