package com.jinm.design.principle.dependencyinversion.interfaceoriented.openinfieldjection;

/**
 * interface oriented jinm.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class Jinm {

    private ICourse course;

    /**
     *  开放属性注入
     */
    public void setCourse(ICourse course) {
        this.course = course;
    }

    /**
     *  面向接口编程
     */
    public void learnCourse(){
        course.learnCourse();
    }

}
