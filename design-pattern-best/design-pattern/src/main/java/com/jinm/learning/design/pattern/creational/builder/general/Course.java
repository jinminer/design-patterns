package com.jinm.learning.design.pattern.creational.builder.general;

/**
 * course.
 * Created by jinm on  2019/07/24.  contact: keanemer.gmail.com
 */

public class Course {

    private String courseName;
    private String courseVideo;
    private String coursePPt;
    private String courseArticle;

    /**
     *  question & answer
     */
    private String courseQA;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public String getCoursePPt() {
        return coursePPt;
    }

    public void setCoursePPt(String coursePPt) {
        this.coursePPt = coursePPt;
    }

    public String getCourseArticle() {
        return courseArticle;
    }

    public void setCourseArticle(String courseArticle) {
        this.courseArticle = courseArticle;
    }

    public String getCourseQA() {
        return courseQA;
    }

    public void setCourseQA(String courseQA) {
        this.courseQA = courseQA;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", coursePPt='" + coursePPt + '\'' +
                ", courseArticle='" + courseArticle + '\'' +
                ", courseQA='" + courseQA + '\'' +
                '}';
    }

}
