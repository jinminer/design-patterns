package com.jinm.pattern.singleton.lazy;

public class SingletonLazyThread extends Thread{

    @Override
    public void run() {
        SingletonLazy s = SingletonLazy.getInstance();
        System.out.println(s);
    }
}
