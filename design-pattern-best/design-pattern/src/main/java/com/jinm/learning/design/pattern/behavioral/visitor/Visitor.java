package com.jinm.learning.design.pattern.behavioral.visitor;

/**
 * visitor implements.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class Visitor implements IVisitor {

    //访问免费课程，打印所有免费课程名称
    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程：" + freeCourse.getName());
    }

    //访问免费课程，打印所有免费课程名称
    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("收费课程：" + codingCourse.getName() + "  价格：" + codingCourse.getPrice() + "元");
    }
}
