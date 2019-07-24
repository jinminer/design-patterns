package com.jinm.learning.design.pattern.creational.builder.best;

/**
 * course test.
 * Created by jinm on  2019/07/25.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  链式编程模式：
         *      1.将产品构建组装的规则直接于相应的产品绑定
         *      2.采用链式编程的模式，减少直接由构造函数构建多参数时出现的参数赋值混乱问题；
         *          应用层代码简洁，直观；
         */
        Course course = new Course.CourseBuilder()
                .buildCourseName("SpringBoot编程思想")
                .buildCourseVideo("SpringBoot编程思想视频")
                .buildCoursePPt("SpringBoot编程思想PPT").build();
        System.out.println(course);

    }

}
