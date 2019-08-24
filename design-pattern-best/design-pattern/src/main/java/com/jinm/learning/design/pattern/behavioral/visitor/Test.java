package com.jinm.learning.design.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * test.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        List<Course> courseList = new ArrayList<>();
        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("git 深入浅出");

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("springboot 编程思想");
        codingCourse.setPrice(998);

        courseList.add(freeCourse);
        courseList.add(codingCourse);

        for (Course course : courseList){
            course.accept(new Visitor());
        }

     }

}
