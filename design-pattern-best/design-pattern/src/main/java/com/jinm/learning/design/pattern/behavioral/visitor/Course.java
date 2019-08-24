package com.jinm.learning.design.pattern.behavioral.visitor;

/**
 * course.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public abstract class Course {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  是否接受访问，在这个方法中可以添加访问权限逻辑
     */
    public abstract void accept(IVisitor visitor);

}
