package com.jinm.learning.design.pattern.behavioral.command;

/**
 * close course video command.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class CloseCourseVideoCommand implements Command{

    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute(){
        courseVideo.close();
    }

}
