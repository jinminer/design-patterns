package com.jinm.learning.design.pattern.creational.prototype.cloneable.abstractprototype;

/**
 * B.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class B extends A {

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        B b1 = (B) b.clone();
        System.out.println(b);
        System.out.println(b1);
    }

}
