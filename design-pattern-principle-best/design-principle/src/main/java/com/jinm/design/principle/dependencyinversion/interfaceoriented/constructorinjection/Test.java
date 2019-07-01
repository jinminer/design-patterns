package com.jinm.design.principle.dependencyinversion.interfaceoriented.constructorinjection;

/**
 * interface oriented test.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {


        /**
         *  构造器注入
         */
        Jinm jinm = new Jinm(new JavaCourse());
        Jinm jinm1 = new Jinm(new PythonCourse());
        Jinm jinm2 = new Jinm(new GolangCourse());

        jinm.learnCourse();
        jinm1.learnCourse();
        jinm2.learnCourse();

    }

}
