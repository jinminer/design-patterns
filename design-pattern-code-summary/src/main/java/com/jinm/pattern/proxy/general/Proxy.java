package com.jinm.pattern.proxy.general;

public class Proxy implements ISubject{

    ISubject subject;

    public Proxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    private void before(){
        System.out.println("前置处理");
    }

    private void after(){
        System.out.println("后置处理");
    }
}
