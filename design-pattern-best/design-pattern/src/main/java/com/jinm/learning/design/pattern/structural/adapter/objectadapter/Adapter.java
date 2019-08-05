package com.jinm.learning.design.pattern.structural.adapter.objectadapter;

/**
 * object adapter.
 * Created by jinm on  2019/08/06.  contact: keanemer.gmail.com
 */

public class Adapter implements Target{

    /**
     *  对象适配器：
     *      在适配器中声明被适配者，并调用其方法，
     *      即通过组合的方式，将目标接口 Target 的实现委托给目标类 Adaptee 去处理
     */
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {

        //......适配逻辑代码
        adaptee.adapteeRequest();
        //......适配逻辑代码

    }

}
