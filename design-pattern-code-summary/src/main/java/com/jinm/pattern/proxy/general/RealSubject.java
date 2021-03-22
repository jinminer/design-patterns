package com.jinm.pattern.proxy.general;

public class RealSubject implements ISubject{
    @Override
    public void request() {
        System.out.println("实际处理");
    }
}
