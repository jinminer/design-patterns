package com.jinm.learning.design.pattern.creational.builder.general;

/**
 * test.
 * Created by jinm on  2019/07/24.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         * 1.对象：Course-课程类；Coach-课程教练类；
         *              CourseBuilder-课程组装规则的抽象模型；CourseActualBuilder-实际的课程组装规则构建器；
         * 2.业务：课程教练(课程管理者)将课程讲师准备好的某课程的相关材料(视频、手记、PPT等)按照一定业务规则进行组装，
         *              最终生成一套完整的课程资料，提供给课程学习者；
         */

        /**
         *  定义课程组装模型:
         *      CourseBuilder作为课程组装规则的抽象模型，可以有多种不同的CourseActualBuilder实现类，从而组装不同的产品：
         *          不同课程的不同资料组装成为不同的课程（Java课程、Python课程等）；
         *          相同课程的相同资料组装成为同一学科不同等级的课程，即同一课程不同表现，如：Java课程分为免费公开课、VIP课程等；
         */
        CourseBuilder courseBuilder = new CourseActualBuilder();

        //指定课程教练
        Coach coach = new Coach();

        //课程教练绑定课程组装规则
        coach.setCourseBuilder(courseBuilder);

        /**
         *  课程教练拿到讲师提供的课程资料(这里通过构造器传参的形式获取资料)，并根据已经制定好的业务规则组装课程资料，
         *      形成最终提供给学员的一套完整课程资料；
         *  接收某种的课程资料，就组装成对应的课程；
         */

        Course course = coach.makeCourse("Java 编程思想",
                "Java 编程思想视频",
                "Java 编程思想PPT",
                "Java 编程思想手记",
                null);
        System.out.println(course);

    }

}
