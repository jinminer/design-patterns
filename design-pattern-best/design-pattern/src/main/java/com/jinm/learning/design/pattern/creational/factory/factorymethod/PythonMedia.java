package com.jinm.learning.design.pattern.creational.factory.factorymethod;

/**
 * python media.
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public class PythonMedia extends Media {

    @Override
    public void produceMedia() {
        System.out.println("录制python视频");
    }

}
