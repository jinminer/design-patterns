package com.jinm.learning.design.pattern.creational.singleton.multithreading.safe.innerclass;

/**
 * lazy singleton inner class.
 * Created by jinm on  2019/07/28.  contact: keanemer.gmail.com
 */

public class LazySingletonStaticInnerClass {

    /**
     *  静态内部类：
     *      性能较高
     *      线程安全
     */
    private LazySingletonStaticInnerClass(){

    }

    private static class InnerClass{
        private static LazySingletonStaticInnerClass instance = new LazySingletonStaticInnerClass();
    }

    public static LazySingletonStaticInnerClass getInstance(){
        return InnerClass.instance;
    }

}
