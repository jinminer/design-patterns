package com.jinm.learning.design.pattern.creational.singleton.reflection.staticinnerclass;

/**
 * lazy singleton inner class.
 * Created by jinm on  2019/07/28.  contact: keanemer.gmail.com
 */

public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass(){
        if (InnerClass.instance != null){
            throw new RuntimeException("单例构造器，禁止反射");
        }
    }

    private static class InnerClass{
        private static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance(){
        return InnerClass.instance;
    }

}
