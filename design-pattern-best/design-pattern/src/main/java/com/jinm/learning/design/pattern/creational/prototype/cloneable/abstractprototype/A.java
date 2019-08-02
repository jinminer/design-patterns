package com.jinm.learning.design.pattern.creational.prototype.cloneable.abstractprototype;

/**
 * A.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class A implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone object......");
        return super.clone();
    }
}
