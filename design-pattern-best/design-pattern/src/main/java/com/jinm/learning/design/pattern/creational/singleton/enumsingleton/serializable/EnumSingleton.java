package com.jinm.learning.design.pattern.creational.singleton.enumsingleton.serializable;

/**
 * Created by jinm on  2019/07/31.
 */

public enum EnumSingleton {

    /**
     *  instance
     */
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
