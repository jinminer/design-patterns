package com.jinm.pattern.singleton.hungry;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonHungryTest {

    public static void main(String[] args) {

        // 1. 正常饿汉模式
//        singletonHungry();

        // 2.多线程
//        singletonHungryMulti();

        // 3.反射破坏单例
//        singletonHungryReflect();

        // 4.序列化破坏单例
//        singleHungrySerialize();

        // 5.静态内部类

        // 6.枚举

        // 7.ThreadLocal
        singleHungryThreadLocal();

    }

    private static void singletonHungry(){
        // 1.正常饿汉
        SingletonHungry s1 = SingletonHungry.getInstance();
        SingletonHungry s2 = SingletonHungry.getInstance();
        System.out.println(s1);
        System.out.println(s2);
    }


    private static void singletonHungryMulti(){

        // 2. 多线程
        Thread t1 = new Thread(new SingletonHungryThread());
        Thread t2 = new Thread(new SingletonHungryThread());
        t1.start();
        t2.start();

    }

    private static void singletonHungryReflect(){

        // 3.反射破坏单例
        SingletonHungry s1 = SingletonHungry.getInstance();
        System.out.println(s1);

        try {
            Class<?> clazz= Class.forName("com.jinm.pattern.singleton.hungry.SingletonHungry");
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            SingletonHungry s2 = (SingletonHungry) constructor.newInstance();
            System.out.println(s2);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void singleHungrySerialize(){

        // 4.序列化破坏单例
        SingletonHungrySerialize s1 = SingletonHungrySerialize.getInstance();
        System.out.println(s1);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("SingletonHungrySerialize.txt"));
            outputStream.writeObject(s1);

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("SingletonHungrySerialize.txt"));
            Object s2 = inputStream.readObject();

            System.out.println(s2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void singleHungryEnum(){

        // 5.枚举


    }

    private static void singleHungryThreadLocal(){

        // 6. thread local
        for (int i= 0; i <5; i ++){
            SingletonThreadLocal s1 = SingletonThreadLocal.getInstance();
            System.out.println(Thread.currentThread() + "--->" +s1);
        }

        Thread t1 = new Thread(new SingletonHungryThreadLocalThread());
        Thread t2 = new Thread(new SingletonHungryThreadLocalThread());
        t1.start();
        t2.start();

    }

}
