package com.jinm.learning.design.pattern.creational.prototype.cloneable.singeltonbreak;

/**
 * test.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

//        HungrySingleton instance = HungrySingleton.getInstance();
//        HungrySingleton instance1= (HungrySingleton) instance.clone();

        HungrySingletonSafe instance = HungrySingletonSafe.getInstance();
        HungrySingletonSafe instance1= (HungrySingletonSafe) instance.clone();

        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);

    }

}
