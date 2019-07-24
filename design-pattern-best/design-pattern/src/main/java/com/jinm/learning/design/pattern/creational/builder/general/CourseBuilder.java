package com.jinm.learning.design.pattern.creational.builder.general;

/**
 * abstract course builder.
 * Created by jinm on  2019/07/24.  contact: keanemer.gmail.com
 */

public abstract class CourseBuilder {

    private String courseName;
    private String courseVideo;
    private String coursePPt;
    private String courseArticle;

    /**
     *  question & answer
     */
    private String courseQA;

    public abstract void buildCourseName(String courseName);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCoursePPt(String coursePPt);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();

}
