package com.jinm.pattern.proxy.staticproxy;

public class ZhangSan implements IPerson{
    @Override
    public void findLove() {
        System.out.println("张三：想找个富婆");
    }
}
