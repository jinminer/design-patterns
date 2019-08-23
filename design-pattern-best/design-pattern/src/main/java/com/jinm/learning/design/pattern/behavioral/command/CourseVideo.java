package com.jinm.learning.design.pattern.behavioral.command;

/**
 * course.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open(){
        System.out.println(this.name + "课程视频开放");
    }

    public void close(){
        System.out.println(this.name + "课程视频关闭");
    }

}
