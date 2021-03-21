package com.jinm.pattern.factory.abstractfactory;

public class JavaCourseFactory extends CourseFacotry{
    @Override
    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    public IViedo createViedo() {
        super.init();
        return new JavaViedo();
    }
}
