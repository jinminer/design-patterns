package com.jinm.learning.design.pattern.creational.builder.general;

/**
 * coach.
 * Created by jinm on  2019/07/24.  contact: keanemer.gmail.com
 */

public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String courseVideo, String coursePPt, String courseArticle, String courseQA){
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCourseVideo(courseVideo);
        this.courseBuilder.buildCoursePPt(coursePPt);
        this.courseBuilder.buildCourseArticle(courseArticle);
        this.courseBuilder.buildCourseQA(courseQA);
        return this.courseBuilder.makeCourse();
    }

}
