package com.jinm.learning.design.pattern.structural.composite;

/**
 * course.
 * Created by jinm on  2019/08/09.  contact: keanemer.gmail.com
 */

public class Course extends CatalogComponent {

    /**
     *  课程类：
     *      相关业务：获取课程名称、获取课程价格、打印内容
     */
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("课程名称：" + this.name + ", 课程价格：" + this.price);
    }
}
