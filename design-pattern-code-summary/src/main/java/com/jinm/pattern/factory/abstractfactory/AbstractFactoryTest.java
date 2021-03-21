package com.jinm.pattern.factory.abstractfactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        CourseFacotry facotry = new JavaCourseFactory();
        facotry.createNote().edit();
        facotry.createViedo().record();
    }

}
