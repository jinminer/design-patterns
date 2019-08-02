package com.jinm.learning.design.pattern.creational.prototype.cloneable.shallow;

import java.util.Date;

/**
 * test.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        People p = new People("jack", new Date(0L));
        People p1 = (People) p.clone();

        System.out.println(p.toString());
        System.out.println(p1.toString());
        System.out.println("              ");

        p.getBirthday().setTime(520520520520520520L);
        System.out.println(p.toString());
        System.out.println(p1.toString());

    }

}
