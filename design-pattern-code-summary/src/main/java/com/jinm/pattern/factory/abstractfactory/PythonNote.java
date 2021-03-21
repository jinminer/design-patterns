package com.jinm.pattern.factory.abstractfactory;

public class PythonNote implements INote{
    @Override
    public void edit() {
        System.out.println("Python 笔记");
    }
}
