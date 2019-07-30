package com.jinm.learning.design.pattern.creational.singleton.staticinnerclass;

/**
 * singleton static inner class.
 * Created by jinm on  2019/07/28.  contact: keanemer.gmail.com
 */

public class SingletonStaticInnerClass {

    /**
     *  静态内部类：
     *      性能较高
     *      线程安全
     */
    private SingletonStaticInnerClass(){

    }

    /**
     *  静态内部类InnerClass在进行初始化的时候，会产生一个类的初始化锁；
     *  如果有多个线程要访问这个类，当且仅当最先持有InnerClass初始化锁的线程，会执行instance变量的赋值操作以及new LazySingletonStaticInnerClass对象的操作；
     *  并且非构造线程在构造线程完成类初始化操作之前，都处于monitor阻塞状态；
     *  这样程序执行重排操作只会发生在构造线程执行方法调用的过程中，对其他非构造线程是不可见的，避免暴露未初始化对象的隐患；
     */
    private static class InnerClass{
        private static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance(){
        return InnerClass.instance;
    }

}
