package com.jinm.learning.design.pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * teacher.
 * Created by jinm on  2019/08/21.  contact: keanemer.gmail.com
 */

public class Teacher implements Observer {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     *  同步方法，实际开发中使用时要结合消息队列使用，提高响应速率
     */
    @Override
    public void update(Observable o, Object arg) {

        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(teacherName + "老师的" + course.getCourseName() + "课程接收到一个" + question.getUserName() + "提交的问答：" + question.getQuestionContent());

    }
}
