package com.jinm.pattern.factory.method;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
