package com.jinm.pattern.adapter.demo.adapter;

public class Test {

    public static void main(String[] args) {
        LoginAdapter adapter = new LoginAdapter();
        adapter.login("kimmin", "123456");
        adapter.wechatLogin("kimmin123456");
    }

}
