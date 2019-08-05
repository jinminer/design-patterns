package com.jinm.learning.design.pattern.structural.adapter.classadapter;

/**
 * target instance.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("预期符合适配规则的目标实例");
    }

}
