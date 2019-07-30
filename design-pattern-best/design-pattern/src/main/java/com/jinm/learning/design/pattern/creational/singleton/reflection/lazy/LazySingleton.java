package com.jinm.learning.design.pattern.creational.singleton.reflection.lazy;

/**
 * lazy singleton.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class LazySingleton {

    /**
     *  由于静态变量需要在静态方法getInstance()调用时才被初始化，
     *  所以当反射生成单例对象执行在单例初始化对象方法之前时，
     *  通过在私有方法内部，添加变量值的判断来防止反射攻击并不奏效，
     *  在多线程场景下，因为每个线程执行代码的顺序具有随机性，所以这种情况很容易发生；
     */
    public static LazySingleton instance = null;

    private LazySingleton(){
        /**
         *  防止反射攻击
         */
        if (instance != null){
            throw new RuntimeException("单例构造器，禁止反射");
        }
    }

    public static synchronized LazySingleton getInstance(){

        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;

    }

}
