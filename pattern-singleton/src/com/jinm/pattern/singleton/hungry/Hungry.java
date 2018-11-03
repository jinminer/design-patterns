package com.jinm.pattern.singleton.hungry;

/**
 * Created by jinm on  2018/10/24.
 */

public class Hungry {

    private Hungry(){};

    //先静态，后动态
    //先属性，后方法
    //先上后下

    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance(){

        return hungry;
    }

}
