package com.jinm.learning.design.pattern.creational.singleton.doublecheckvolatile;

/**
 * lazy singleton double check volatile.
 * Created by jinm on  2019/07/28.  contact: keanemer.gmail.com
 */

public class LazySingletonVolatile {

    /**
     *  volatitle:
     *      防止重排序
     *      实现可见性
     */
    public static volatile LazySingletonVolatile instance = null;

    private LazySingletonVolatile(){

    }

    public static LazySingletonVolatile getInstance(){

        if (instance == null){
            synchronized (LazySingletonVolatile.class){
                if (instance == null){
                    instance = new LazySingletonVolatile();
                }
            }
        }

        return instance;

    }

}
