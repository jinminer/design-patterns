package com.jinm.pattern.proxy.dynamic.jdk.customize;


import com.jinm.pattern.proxy.dynamic.jdk.customize.IPerson;

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
