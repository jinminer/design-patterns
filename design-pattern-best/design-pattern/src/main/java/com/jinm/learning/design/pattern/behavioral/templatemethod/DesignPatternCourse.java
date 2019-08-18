package com.jinm.learning.design.pattern.behavioral.templatemethod;

/**
 * design pattern course.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

/**
 *  设计模式课程
 */
public class DesignPatternCourse extends ACourse {

    @Override
    void packageCourse() {
        System.out.println("提供课程的 Java 源代码");
    }

    /**
     *  覆写父类暴露出来的钩子方法，用来控制可选行为 ：编写笔记
     */
    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
