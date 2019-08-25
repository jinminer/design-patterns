package com.jinm.learning.design.pattern.creational.factory.simplefactory.best;

/**
 * test.
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  简单工厂模式：应用层Test类需要什么视频，只需要传入一个参数即可
         *  优点：不引入具体的类，如果新增一个视频类型，在应用层只需传入对应的参数即可，并不需要知道其底层的实现
         *  缺点：如果新增一种视频类型，需要修改MediaFactory类，并不符合开闭原则，修改会带来风险
         */
        MediaFactory factory = new MediaFactory();
//        Media media = factory.getMedia("java");
        Media media = factory.getMedia("golang");

        media.produceMedia();

        /**
         *  通过反射获取实例，不需要修改factory工厂类，符合开闭原则
         */
        ReflectionMediaFactory reflectionMediaFactory = new ReflectionMediaFactory();
        Media reflectionMedia = reflectionMediaFactory.getMedia(JavaMedia.class);
        reflectionMedia.produceMedia();

    }

}
