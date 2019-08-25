package com.jinm.learning.design.pattern.creational.factory.factorymethod;

/**
 * test.
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  工厂方法模式：
         *      把具体实现类的创建交由不同类型的工厂类去做，将应用层(客户端调用者)与底层服务(基础类)分离、解耦；
         *      应用层需要什么样的服务(基础类)，只需要调用相应的工厂类即可；
         *      不必像简单工厂那样去传一个标记参数过去；
         *      增加一个新的业务类型，只需要增加对应的业务类和业务工厂类即可，客户端改动较小，对原有业务无影响；
         *
         */

//        MediaFactory factory = new JavaMediaFactory();
        MediaFactory factory = new PythonMediaFactory();
        Media media = factory.produce();
        media.produceMedia();


    }

}
