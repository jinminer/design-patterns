package com.jinm.design.principle.dependencyinversion.interfaceoriented;

/**
 * implementation JavaCourse.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class JavaCourse implements ICourse {

    @Override
    public void learnCourse() {
        System.out.println("java 课程学习");
    }

}
