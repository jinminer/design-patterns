package com.jinm.learning.design.pattern.creational.factory.factorymethod;

/**
 * java media factory.
 * Created by jinm on  2019/07/21.  contact: keanemer.gmail.com
 */

public class JavaMediaFactory extends MediaFactory {

    @Override
    public Media produce() {
        return new JavaMedia();
    }

}
