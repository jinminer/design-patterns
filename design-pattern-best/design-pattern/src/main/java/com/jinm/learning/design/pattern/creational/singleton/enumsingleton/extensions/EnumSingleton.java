package com.jinm.learning.design.pattern.creational.singleton.enumsingleton.extensions;

/**
 * Created by jinm on  2019/07/31.
 */

public enum EnumSingleton {

    /**
     *  declare enum method
     */
    INSTANCE{
        @Override
        protected void enumMethodTest(){
            System.out.println("enum method test.....");
        }
    };

    /**
     *  该方法必须写，否则无法调用
     */
    protected abstract void enumMethodTest();

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
