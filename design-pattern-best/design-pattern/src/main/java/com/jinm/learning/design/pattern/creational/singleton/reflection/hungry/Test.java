package com.jinm.learning.design.pattern.creational.singleton.reflection.hungry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * reflection break hungry singleton.
 * Created by jinm on  2019/07/31.  contact: keanemer.gmail.com
 */

public class Test {

    /**
     *  反射破坏单例
     */

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HungrySingleton instance = HungrySingleton.getInstance();

        Constructor constructor = HungrySingleton.class.getDeclaredConstructor();

        //修改私有构造器的访问权限
        constructor.setAccessible(true);
        HungrySingleton instance1 = (HungrySingleton) constructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);

    }

}
