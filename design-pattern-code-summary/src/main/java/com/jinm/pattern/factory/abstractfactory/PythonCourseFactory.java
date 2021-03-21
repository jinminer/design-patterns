package com.jinm.pattern.factory.abstractfactory;

public class PythonCourseFactory extends CourseFacotry{
    @Override
    public INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    public IViedo createViedo() {
        return new PythonViedo();
    }
}
