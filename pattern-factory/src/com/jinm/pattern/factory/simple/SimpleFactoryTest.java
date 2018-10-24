package com.jinm.pattern.factory.simple;

/**
 *  小作坊式的工厂模型 （简单工厂模式）
 *
 * Created by jinm on  2018/10/23.
 */

public class SimpleFactoryTest {

    public static void main(String[] args) {

        //这个new的过程实际上非常复杂
        //有了人民币就不需要自己new了
        //System.out.println(new Mengniu().getName());

        //小作坊的生产模式
        //用户本身不再关系生产的具体过程，只需要关心这个结果

        //假如：特仑苏、蒙牛、伊利
        //成分配比都是不一样的
        SimpleFactory simpleFactory = new SimpleFactory();

        //用户把需求告诉工厂
        //创建产品的过程影藏了，而用户完全不清楚该产品是怎么产生的
        System.out.println(simpleFactory.getMilk("伊利"));

    }

}
