package com.jinm.pattern.proxy.dynamic.jdk;


public class LiSi implements IPerson {
    @Override
    public void findLove() {
        System.out.println("李四：要个美女");
    }

    @Override
    public void insure() {
        System.out.println("李四：10万");
    }
}
