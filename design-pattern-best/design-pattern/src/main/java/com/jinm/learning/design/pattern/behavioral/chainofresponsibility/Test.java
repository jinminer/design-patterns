package com.jinm.learning.design.pattern.behavioral.chainofresponsibility;

/**
 * test.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Course course = new Course();
        course.setName("Java 设计模式课程 --- by keanemer");
        course.setArticle("Java 设计模式课程笔记");
        course.setVideo("Java 设计模式课程视频");

        ArticleApprover articleApprover = new ArticleApprover();
        VideoApprover videoApprover = new VideoApprover();

        /**
         *  这里的链路中不同处理环节的顺序在客户端指定
         */
        videoApprover.approver = articleApprover;
        //这里注意不要进行循环调用，会造成  stack over flow
        //articleApprover.approver = videoApprover;
        videoApprover.deploy(course);

    }

}
