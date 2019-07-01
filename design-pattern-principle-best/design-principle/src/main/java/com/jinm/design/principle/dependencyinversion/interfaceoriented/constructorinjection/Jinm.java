package com.jinm.design.principle.dependencyinversion.interfaceoriented.constructorinjection;

/**
 * interface oriented jinm.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class Jinm {

    private ICourse course;

    /**
     *  通过构造器注入
     */
    public Jinm(ICourse course) {
        this.course = course;
    }

    /**
     *  面向接口编程
     */
    public void learnCourse(){
        course.learnCourse();
    }

}
