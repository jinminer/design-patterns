package com.jinm.learning.design.pattern.behavioral.observer;

import com.jinm.learning.design.pattern.creational.singleton.lazy.multithreading.unsafe.T;

/**
 * test.
 * Created by jinm on  2019/08/22.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Course course = new Course("Java 设计模式");
        Teacher teacher = new Teacher("rose");
        Teacher teacher1 = new Teacher("king");

        //为主题对象添加观察者
        course.addObserver(teacher);
        course.addObserver(teacher1);

        //业务代码
        Question question = new Question();
        question.setUserName("jack");
        question.setQuestionContent("jdk代理实现和cglib代理实现的区别");

        course.produceQuestion(course, question);

    }

}
