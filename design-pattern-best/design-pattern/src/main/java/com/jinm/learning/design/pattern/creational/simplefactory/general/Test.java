package com.jinm.learning.design.pattern.creational.simplefactory.general;

/**
 * test.
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  业务场景：需要java视频和python视频，普通做法直接new
         *  缺点：Test作为应用层，需要引入JavaMedia和PythonMedia这两个类
         */
        Media media = new JavaMedia();
        media.produceMedia();
        Media media1 = new PythonMedia();
        media1.produceMedia();
    }

}
