package com.jinm.pattern.factory.method;

public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("Java 课程被创建");
    }
}
