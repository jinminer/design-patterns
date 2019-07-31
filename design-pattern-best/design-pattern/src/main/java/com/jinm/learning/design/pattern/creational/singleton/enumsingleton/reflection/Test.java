package com.jinm.learning.design.pattern.creational.singleton.enumsingleton.reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * test.
 * Created by jinm on  2019/07/31.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance = EnumSingleton.getInstance();

        Constructor constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSingleton instance1 = (EnumSingleton) constructor.newInstance("jinm", 666);

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);

    }
}
