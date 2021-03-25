package com.jinm.pattern.adapter.objectadapter;

public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {

        // 实现新业务
        // 适配旧业务
        adaptee.specificRequest();
        System.out.println("新的通用业务逻辑");

    }
}
