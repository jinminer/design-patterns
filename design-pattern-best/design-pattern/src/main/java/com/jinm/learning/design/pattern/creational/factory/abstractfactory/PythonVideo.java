package com.jinm.learning.design.pattern.creational.factory.abstractfactory;

/**
 * python.
 * Created by jinm on  2019/07/22.  contact: keanemer.gmail.com
 */

public class PythonVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制python视频");
    }
}
