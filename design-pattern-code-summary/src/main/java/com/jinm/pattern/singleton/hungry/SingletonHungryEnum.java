package com.jinm.pattern.singleton.hungry;

public enum SingletonHungryEnum {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static SingletonHungryEnum getInstance(){
        return INSTANCE;
    }
}
