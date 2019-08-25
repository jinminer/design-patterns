package com.jinm.learning.design.pattern.creational.factory.abstractfactory;

/**
 * java factory.
 * Created by jinm on  2019/07/22.  contact: keanemer.gmail.com
 */

public class JavaFactory implements CourseFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }

}
