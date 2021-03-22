package com.jinm.pattern.proxy.dynamic.cglib;

public class CglibTest {

    public static void main(String[] args) {

        ZhangSan zhangSan = (ZhangSan) new CglibMeipo().getInstance(ZhangSan.class);
        zhangSan.findLove();
        zhangSan.insure();

    }

}
