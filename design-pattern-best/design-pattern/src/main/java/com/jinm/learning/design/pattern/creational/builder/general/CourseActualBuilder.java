package com.jinm.learning.design.pattern.creational.builder.general;

/**
 * course actual builder.
 * Created by jinm on  2019/07/24.  contact: keanemer.gmail.com
 */

public class CourseActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void buildCourseName(String courseName) {
        course.setCourseName(courseName);
    }

    @Override
    public void buildCourseVideo(String courseVideo) {
        course.setCourseVideo(courseVideo);
    }

    @Override
    public void buildCoursePPt(String coursePPt) {
        course.setCoursePPt(coursePPt);
    }

    @Override
    public void buildCourseArticle(String courseArticle) {
        course.setCourseArticle(courseArticle);
    }

    @Override
    public void buildCourseQA(String courseQA) {
        course.setCourseQA(courseQA);
    }

    @Override
    public Course makeCourse() {
        return course;
    }

}
