package com.jinm.design.principle.dependencyinversion.interfaceoriented.openinfieldjection;

/**
 * interface oriented test.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  开放属性注入，使得基层类Jinm保持单例
         */
        Jinm jinm = new Jinm();
        jinm.setCourse(new JavaCourse());

        jinm.learnCourse();
        jinm.setCourse(new PythonCourse());

        jinm.learnCourse();
        jinm.setCourse(new GolangCourse());

        jinm.learnCourse();

    }

}
