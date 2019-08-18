package com.jinm.learning.design.pattern.behavioral.iterator;

/**
 * test.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Course course1 = new Course("Java 课程");
        Course course2 = new Course("设计模式 课程");
        Course course3 = new Course("spring 课程");
        Course course4 = new Course("Python 课程");
        Course course5 = new Course("Golanguage 课程");
        Course course6 = new Course("k8s 课程");

        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.addCourse(course1);
        courseAggregate.addCourse(course2);
        courseAggregate.addCourse(course3);
        courseAggregate.addCourse(course4);
        courseAggregate.addCourse(course5);
        courseAggregate.addCourse(course6);

        System.out.println("------课程列表------");
        printCourses(courseAggregate);

        courseAggregate.removeCourse(course3);
        courseAggregate.removeCourse(course4);
        System.out.println("------删除操作之后的课程列表------");
        printCourses(courseAggregate);

    }

    private static void printCourses(CourseAggregate courseAggregate){
        CourseIterator iterator = courseAggregate.getCourseIterator();
        while (!iterator.isLastCourse()){
            Course course = iterator.nextCourse();
            System.out.println(course.getName());
        }
    }

}
