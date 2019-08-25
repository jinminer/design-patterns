package com.jinm.learning.design.pattern.creational.factory.simplefactory.best;

/**
 * reflection media factory .
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public class ReflectionMediaFactory {

    /**
     *  使用反射生成对象
     *  优点：新增业务类型时，不需要修改factory工厂类，符合开闭原则
     */
    public Media getMedia(Class clazz){
        Media media = null;
        try {
            media = (Media) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return media;
    }

}
