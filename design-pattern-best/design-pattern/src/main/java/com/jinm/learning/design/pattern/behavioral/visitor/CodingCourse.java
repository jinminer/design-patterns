package com.jinm.learning.design.pattern.behavioral.visitor;

/**
 * coding course.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class CodingCourse extends Course {

    /**
     *  实战课程，收费，有价格
     */

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
