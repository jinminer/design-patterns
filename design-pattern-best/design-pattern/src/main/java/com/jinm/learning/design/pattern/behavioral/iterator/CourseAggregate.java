package com.jinm.learning.design.pattern.behavioral.iterator;

/**
 * course aggregate.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

public interface CourseAggregate {

    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator getCourseIterator();

}
