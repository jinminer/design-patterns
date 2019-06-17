package com.jinm.design.principle.openclosed;

/**
 * java course.
 * Created by jinm on  2019/06/18.  contact: keanemer.gmail.com
 */

public class JavaCourse implements ICourse {

    private Integer id;

    private String name;

    private Double price;

    public JavaCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
