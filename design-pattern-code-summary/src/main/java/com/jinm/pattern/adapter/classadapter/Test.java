package com.jinm.pattern.adapter.classadapter;

public class Test {

    public static void main(String[] args) {
//        Target adapter = new Adapter();
//        adapter.request();

        // 类适配器会暴露被适配类的接口
        Adapter adapter1 = new Adapter();
        adapter1.request();
        adapter1.specificRequest();

    }

}
