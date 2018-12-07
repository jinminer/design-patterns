package com.jinm.pattern.factory.function;

/**
 *  方法工厂模式
 * Created by jinm on  2018/10/23.
 */

public class FactoryTest {

    public static void main(String[] args) {

        //货比三家
        //不知道谁好谁坏
        //配置

        Factory factory = new MengniuFactory();
        System.out.println(factory.getMilk());

    }

}
