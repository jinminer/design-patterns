package com.jinm.pattern.factory.method;

public class SimpleFactoryTest {

    public static void main(String[] args) {

        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();
    }

}
