package com.jinm.pattern.adapter.objectadapter;

public class Test {

    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }

}
