package com.jinm.design.principle.dependencyinversion.implementationoriented;

/**
 * test.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  面向实现编程
         *  Test类-高层类；Jinm-低层类
         *  Test类作为应用层，调用低层类JInm的方法实现自己的业务
         *  Test类和Jinm类是紧密耦合的，Test应用层想要实现什么样的功能完全依赖于，Jinm类的实现
         *  比如，当Test想要新增一门C语言的学习课程，Jinm 类就必须新增一个C语言学习的方法，从而实现Test类的新增业务
         */
        Jinm jinm = new Jinm();
        jinm.GolangCourse();
        jinm.JavaCourse();
        jinm.PythonCourse();

    }

}
