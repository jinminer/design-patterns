package com.jinm.pattern.adapter.interfaceadapter;

public abstract class Adapter implements Target{

    protected Adaptee adaptee;
    public Adapter(Adaptee adaptee){
        this.adaptee= adaptee;
    }

    @Override
    public void request1() {

    }

    @Override
    public void request2() {

    }

    @Override
    public void request3() {

    }

    @Override
    public void request4() {

    }
}
