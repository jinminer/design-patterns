package com.jinm.learning.design.pattern.behavioral.command;

/**
 * test.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        CourseVideo courseVideo = new CourseVideo("Java 设计模式课程视频 -- by keanemer");

        Command closeCommand = new CloseCourseVideoCommand(courseVideo);
        Command openCommand = new OpenCourseVideoCommand(courseVideo);

        Staff staff = new Staff();
        staff.addCommand(closeCommand);
        staff.addCommand(openCommand);

        staff.executeCommands();

    }

}
