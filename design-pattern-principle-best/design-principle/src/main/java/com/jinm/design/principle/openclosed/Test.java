package com.jinm.design.principle.openclosed;

/**
 * test.
 * Created by jinm on  2019/06/18.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        ICourse course = new JavaCourse(99, "数据结构", 998d);
        System.out.println("课程ID:" + course.getId() + "课程名称:" + course.getName() + "课程价格:" + course.getPrice() + "元");

    }

}
