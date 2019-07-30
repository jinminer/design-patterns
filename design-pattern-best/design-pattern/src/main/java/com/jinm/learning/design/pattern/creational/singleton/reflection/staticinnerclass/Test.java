package com.jinm.learning.design.pattern.creational.singleton.reflection.staticinnerclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * static inner class reflection break singleton.
 * Created by jinm on  2019/07/31.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        SingletonStaticInnerClass instance = SingletonStaticInnerClass.getInstance();

        Constructor constructor = SingletonStaticInnerClass.class.getDeclaredConstructor();
        //修改私有构造器的访问权限
        constructor.setAccessible(true);
        SingletonStaticInnerClass instance1 = (SingletonStaticInnerClass) constructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);

    }

}
