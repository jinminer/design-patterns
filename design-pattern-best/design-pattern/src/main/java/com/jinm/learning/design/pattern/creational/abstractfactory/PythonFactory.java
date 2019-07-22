package com.jinm.learning.design.pattern.creational.abstractfactory;

/**
 * python factory.
 * Created by jinm on  2019/07/22.  contact: keanemer.gmail.com
 */

public class PythonFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
