package com.jinm.pattern.singleton.hungry;

public class SingletonHungryThreadLocalThread extends Thread{

    @Override
    public void run() {
        for (int i= 0; i <10; i ++){
            SingletonThreadLocal s1 = SingletonThreadLocal.getInstance();
            System.out.println(Thread.currentThread() + "--->" +s1);
        }
    }
}
