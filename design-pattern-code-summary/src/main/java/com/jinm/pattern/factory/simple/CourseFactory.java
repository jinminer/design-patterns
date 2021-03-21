package com.jinm.pattern.factory.simple;

public class CourseFactory {

    public ICourse create(Class<? extends ICourse> clazz){
        if (clazz !=null){
            try {
                return clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
