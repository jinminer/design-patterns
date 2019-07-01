package com.jinm.design.principle.dependencyinversion.interfaceoriented.constructorinjection;

/**
 * implementation GolangCourse.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class GolangCourse implements ICourse {

    @Override
    public void learnCourse() {
        System.out.println("golang 课程学习");
    }

}
