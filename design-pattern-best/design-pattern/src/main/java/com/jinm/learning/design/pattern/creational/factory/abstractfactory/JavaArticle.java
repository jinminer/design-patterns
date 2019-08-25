package com.jinm.learning.design.pattern.creational.factory.abstractfactory;

/**
 * java article.
 * Created by jinm on  2019/07/22.  contact: keanemer.gmail.com
 */

public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写java手记");
    }
}
