package com.jinm.learning.design.pattern.creational.singleton.reflection.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * lazy singleton reflection break.
 * Created by jinm on  2019/07/31.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /**
         *  调用单例方法初始化对象，在反射初始化对象之前，
         *  通过在私有方法中添加静态变量值得判断能够防止反射攻击
         */
        LazySingleton instance = LazySingleton.getInstance();
        Constructor constructor = LazySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton instance1 = (LazySingleton) constructor.newInstance();

        /**
         *  调用单例方法初始化对象，在反射初始化对象之后，
         *  通过在私有方法中添加静态变量值得判断不能防止反射攻击，
         *  这种情况在多线程场景中，很可能会发生
         */
//        LazySingleton instance = LazySingleton.getInstance();

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);
    }

}
