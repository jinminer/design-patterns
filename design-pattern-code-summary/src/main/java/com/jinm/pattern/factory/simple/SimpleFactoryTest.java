package com.jinm.pattern.factory.simple;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        ICourse course = new CourseFactory().create(PythonCourse.class);

        course.record();
    }

}
