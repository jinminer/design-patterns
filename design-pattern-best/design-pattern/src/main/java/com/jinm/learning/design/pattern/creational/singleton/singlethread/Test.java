package com.jinm.learning.design.pattern.creational.singleton.singlethread;

/**
 * test.
 * Created by jinm on  2019/07/26.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);

    }

}
