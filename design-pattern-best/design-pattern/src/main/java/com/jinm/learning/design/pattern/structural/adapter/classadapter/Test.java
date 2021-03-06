package com.jinm.learning.design.pattern.structural.adapter.classadapter;

/**
 * test.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        //具体目标类方法调用
        Target target = new ConcreteTarget();
        target.request();

        //适配器模式委托方法调用
        Target adapterTarget = new Adaper();
        adapterTarget.request();

    }

}
