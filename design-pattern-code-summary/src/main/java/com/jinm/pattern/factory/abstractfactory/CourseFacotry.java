package com.jinm.pattern.factory.abstractfactory;

public abstract class CourseFacotry {

    public void init(){
        System.out.println("课程初始化");
    }

    public abstract INote createNote();

    public abstract IViedo createViedo();

}
