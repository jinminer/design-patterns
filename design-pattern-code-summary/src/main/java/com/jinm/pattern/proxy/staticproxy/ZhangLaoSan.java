package com.jinm.pattern.proxy.staticproxy;

public class ZhangLaoSan implements IPerson{

    private ZhangSan zhangSan;

    public ZhangLaoSan(ZhangSan zhangSan) {
        this.zhangSan = zhangSan;
    }

    @Override
    public void findLove() {

        System.out.println("张老三：贤惠麻利");

        zhangSan.findLove();

        System.out.println("张老三：约定见面");

    }
}
