package com.jinm.pattern.adapter.interfaceadapter;

public class Test {

    public static void main(String[] args) {
        final Adapter adapter = new Adapter(new Adaptee()) {
            @Override
            public void request0() {
                System.out.println("新业务逻辑");
                adaptee.specificRequest();
            }
        };
        adapter.request0();

}
}
