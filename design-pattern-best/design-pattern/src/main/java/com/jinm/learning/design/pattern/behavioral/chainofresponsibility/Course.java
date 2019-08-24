package com.jinm.learning.design.pattern.behavioral.chainofresponsibility;

/**
 * course.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class Course {

    /**
     *  课程
     *  责任链中的主体对象：被处理对象
     */

    private String name;
    private String article;
    private String video;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", article='" + article + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
