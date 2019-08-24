package com.jinm.learning.design.pattern.behavioral.visitor;

/**
 * .
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public interface IVisitor {

    public void visit(FreeCourse freeCourse);
    public void visit(CodingCourse codingCourse);

}
