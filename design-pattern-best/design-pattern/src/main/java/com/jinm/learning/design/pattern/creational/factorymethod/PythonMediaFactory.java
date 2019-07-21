package com.jinm.learning.design.pattern.creational.factorymethod;

/**
 * python media factory.
 * Created by jinm on  2019/07/21.  contact: keanemer.gmail.com
 */

public class PythonMediaFactory extends MediaFactory {

    @Override
    public Media produce() {
        return new PythonMedia();
    }

}
