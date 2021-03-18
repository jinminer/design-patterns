package com.jinm.pattern.singleton.lazy;

public class SingletonLazyTest {

    public static void main(String[] args) {

        // 1.正常懒汉模式
//        singletonLazy();

        // 2.多线程破坏懒汉单例
        singletonLazyMulti();

    }

    public static void singletonLazy(){

        // 1.正常懒汉模式
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1);
        System.out.println(s2);

    }

    public static void singletonLazyMulti(){

        // 2.多线程破坏懒汉单例
        Thread t1 = new Thread(new SingletonLazyThread());
        Thread t2 = new Thread(new SingletonLazyThread());

        t1.start();
        t2.start();

    }

    public static void singletonLazyMultiSynchronize(){

        // 2.多线程破坏懒汉单例
        Thread t1 = new Thread(new SingletonLazyThread());
        Thread t2 = new Thread(new SingletonLazyThread());

        t1.start();
        t2.start();

    }

}
