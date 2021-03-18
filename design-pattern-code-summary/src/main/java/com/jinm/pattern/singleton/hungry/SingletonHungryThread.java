package com.jinm.pattern.singleton.hungry;

public class SingletonHungryThread extends Thread{

    @Override
    public void run() {
        SingletonHungry s1 = SingletonHungry.getInstance();
        System.out.println(s1);
    }
}
