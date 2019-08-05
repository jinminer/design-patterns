package com.jinm.learning.design.pattern.structural.adapter.classadapter;

/**
 * test.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adaper();
        adapterTarget.request();

    }

}
