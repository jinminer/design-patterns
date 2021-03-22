package com.jinm.pattern.proxy.staticproxy;

public class Test {

    public static void main(String[] args) {
        IPerson zhangLaoSan = new ZhangLaoSan(new ZhangSan());
        zhangLaoSan.findLove();
    }

}
