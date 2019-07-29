package com.jinm.learning.design.pattern.creational.singleton.hungry;

/**
 * hungry singleton.
 * Created by jinm on  2019/07/29.  contact: keanemer.gmail.com
 */

public class HungrySingleton {

    /**
     *  懒汉模式：
     *      在类加载时，就完成初始化，不论方法是否被调用，该过程都会发生；
     *      适用于内部构造简单，创建花费资源较少的单例模型
     *
     */

    private HungrySingleton(){

    }

    private static final HungrySingleton instance = new HungrySingleton();

    /**
     *  两种写法相同
     */
//    private static final HungrySingleton instance;
//    static {
//        instance = new HungrySingleton();
//    }

    public static HungrySingleton getInstance(){
        return instance;
    }

}
