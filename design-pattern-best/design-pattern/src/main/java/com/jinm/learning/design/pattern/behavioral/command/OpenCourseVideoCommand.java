package com.jinm.learning.design.pattern.behavioral.command;

/**
 * open course video command.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class OpenCourseVideoCommand implements Command{

    private CourseVideo courseVideo;

    public OpenCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute(){
        courseVideo.open();
    }

}
