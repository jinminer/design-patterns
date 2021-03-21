package com.jinm.pattern.factory.method;

public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("Python 课程被创建");
    }
}
