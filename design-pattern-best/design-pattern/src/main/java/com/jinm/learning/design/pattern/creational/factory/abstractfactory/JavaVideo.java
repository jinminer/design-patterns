package com.jinm.learning.design.pattern.creational.factory.abstractfactory;

/**
 * java video.
 * Created by jinm on  2019/07/22.  contact: keanemer.gmail.com
 */

public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制java视频");
    }
}
