package com.jinm.pattern.proxy.dynamic.jdk;


public class ZhangSan implements IPerson {
    @Override
    public void findLove() {
        System.out.println("张三：要个富婆");
    }

    @Override
    public void insure() {
        System.out.println("张三：50万");
    }
}
