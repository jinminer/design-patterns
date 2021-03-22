package com.jinm.pattern.proxy.dynamic.jdk;

public class Test {

    public static void main(String[] args) {

        new JDKMeipo().getInstance(new ZhangSan()).findLove();

//        JDKMeipo meipo = new JDKMeipo();
//        IPerson zhangSan = meipo.getInstance(new ZhangSan());
//        zhangSan.findLove();
//        zhangSan.insure();

//        IPerson liSi = new JDKMeipo().getInstance(new LiSi());
//        liSi.findLove();
//        liSi.insure();

    }

}
