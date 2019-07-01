package com.jinm.design.principle.dependencyinversion.interfaceoriented;

/**
 * interface oriented test.
 * Created by jinm on  2019/07/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  面向接口编程
         *  Test类-高层类；Jinm-低层类；两者并无业务相关性；两者的关系是低耦合的；
         *  Test类作为应用层，由它自己去决定学习什么课程
         *  低层类Jinm 只提供一个学习的行为，并不关心学习的具体内容时什么
         *  基层类Jinm是业务模型的抽象，他将具体的业务实现交由Test类去处理
         */
        Jinm jinm = new Jinm();
        JavaCourse javaCourse = new JavaCourse();
        PythonCourse pythonCourse = new PythonCourse();
        GolangCourse golangCourse = new GolangCourse();
        jinm.learnCourse(javaCourse);
        jinm.learnCourse(pythonCourse);
        jinm.learnCourse(golangCourse);

    }

}
