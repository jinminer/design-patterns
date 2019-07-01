package com.jinm.design.principle.dependencyinversion.interfaceoriented;

/**
 * implementation PythonCourse.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class PythonCourse implements ICourse {

    @Override
    public void learnCourse() {
        System.out.println("python 课程学习");
    }

}
