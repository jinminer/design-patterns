package com.jinm.learning.design.pattern.creational.factorymethod;

/**
 * media factory.
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public abstract class MediaFactory {

    /**
     *  1.定义媒体类抽象类，把具体媒体实例的创建交给不同的媒体工厂实例去做，
     *      使得应用层(客户端)与底层服务(基础类)解耦
     *  2.将媒体类定义为抽象类和接口类的区别：
     *      如果实现类的具体实现都不确定，即可定义为接口类；
     *      如果实现类中有统一的明确定义的方法，即可使用抽象类来定义
     *
     */

    public abstract Media produce();

}
