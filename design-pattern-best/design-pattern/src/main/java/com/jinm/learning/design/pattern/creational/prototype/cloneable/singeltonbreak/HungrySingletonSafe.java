package com.jinm.learning.design.pattern.creational.prototype.cloneable.singeltonbreak;

/**
 * hungry singleton.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class HungrySingletonSafe implements Cloneable{

    private static HungrySingletonSafe instance = new HungrySingletonSafe();

    private HungrySingletonSafe(){

    }

    public static HungrySingletonSafe getInstance(){
        return instance;
    }

    /**
     *  重写克隆方法
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
