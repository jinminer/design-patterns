package com.jinm.learning.design.pattern.behavioral.observer;

import java.util.Observable;

/**
 * course.
 * Created by jinm on  2019/08/21.  contact: keanemer.gmail.com
 */

public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(Course course, Question question){
        System.out.println(question.getUserName() + "在" + course.courseName + "提交了一个问题");

        //修改主题状态
        setChanged();

        //异步通知观察者
        notifyObservers(question);

    }

}
