package com.jinm.learning.design.pattern.creational.factory.factorymethod;

/**
 * golang media factory.
 * Created by jinm on  2019/07/21.  contact: keanemer.gmail.com
 */

public class GolangMediaFactory extends MediaFactory {

    @Override
    public Media produce() {
        return new GolangMedia();
    }

}
