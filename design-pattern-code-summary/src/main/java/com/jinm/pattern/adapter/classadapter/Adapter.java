package com.jinm.pattern.adapter.classadapter;

public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {

        // 实现新业务
        // 适配旧业务
        super.specificRequest();
        System.out.println("新的通用业务逻辑");

    }
}
