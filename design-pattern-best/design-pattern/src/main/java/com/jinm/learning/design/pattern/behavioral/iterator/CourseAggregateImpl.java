package com.jinm.learning.design.pattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * course aggregate implements.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

public class CourseAggregateImpl implements CourseAggregate {

    private List courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        return new CourseIteratorImpl(courseList);
    }

}
