package com.jinm.learning.design.pattern.behavioral.visitor;

/**
 * free course.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class FreeCourse extends Course {

    /**
     *  免费课程，无价格
     */

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
