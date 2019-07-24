package com.jinm.learning.design.pattern.creational.builder.best;

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

    public Course(CourseBuilder courseBuilder) {

        this.courseName = courseBuilder.courseName;
        this.courseVideo = courseBuilder.courseVideo;
        this.coursePPt = courseBuilder.coursePPt;
        this.courseArticle = courseBuilder.courseArticle;
        this.courseQA = courseBuilder.courseQA;

    }

    public static class CourseBuilder{

        private String courseName;
        private String courseVideo;
        private String coursePPt;
        private String courseArticle;

        /**
         *  question & answer
         */
        private String courseQA;


        public CourseBuilder buildCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildCourseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBuilder buildCoursePPt(String coursePPt) {
            this.coursePPt = coursePPt;
            return this;
        }

        public CourseBuilder buildCourseArticle(String courseArticle) {
            this.courseArticle = courseArticle;
            return this;
        }

        public CourseBuilder buildCourseQA(String courseQA) {
            this.courseQA = courseQA;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

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
