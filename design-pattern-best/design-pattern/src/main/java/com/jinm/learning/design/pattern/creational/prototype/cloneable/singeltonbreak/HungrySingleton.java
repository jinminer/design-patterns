package com.jinm.learning.design.pattern.creational.prototype.cloneable.singeltonbreak;

/**
 * hungry singleton.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class HungrySingleton implements Cloneable{

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }

    /**
     *  单例类实现克隆方法
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
