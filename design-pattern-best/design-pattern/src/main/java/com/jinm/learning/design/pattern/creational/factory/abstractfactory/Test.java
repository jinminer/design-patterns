package com.jinm.learning.design.pattern.creational.factory.abstractfactory;

/**
 * test.
 * Created by jinm on  2019/07/22.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  抽象工厂模式：
         *      主要关注于产品族的生产问题，一旦指定了产品族的生产工厂，那么所产出的产品必定属于同一产品族；
         *      将应用层与产品族的具体实现解耦，客户端只需要知道对应产品族的工厂类即可；
         *      抽象工厂类的创建，避免了客户端处理涉及到多产品族业务中出现的产品混合问题：比如JavaVideo和PythonVideo归为一个产品族
         */

//        CourseFactory courseFactory = new JavaFactory();
        CourseFactory courseFactory = new PythonFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();

    }

}
