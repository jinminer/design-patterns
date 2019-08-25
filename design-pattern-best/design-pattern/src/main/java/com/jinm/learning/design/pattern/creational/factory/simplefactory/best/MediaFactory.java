package com.jinm.learning.design.pattern.creational.factory.simplefactory.best;

/**
 * media factory.
 * Created by jinm on  2019/07/16.  contact: keanemer.gmail.com
 */

public class MediaFactory {

    public Media getMedia(String mediaType){
        if ("java".equals(mediaType.toLowerCase())){
            return new JavaMedia();
        }else if ("python".equals(mediaType.toLowerCase())){
            return new PythonMedia();
        }else if ("golang".equals(mediaType.toLowerCase())){
            return new GolangMedia();
        }
        return null;
    }

    /**
     *  静态方法：使用类名直接调用
     *  优点：可以通过类名直接调用，简单快捷
     *  缺点：无法通过继承去修改类的行为
     *  原则：工厂类没有被继承和重写的需求
     */
    public static Media getMediaStatic(String mediaType){
        if ("java".equals(mediaType.toLowerCase())){
            return new JavaMedia();
        }else if ("python".equals(mediaType.toLowerCase())){
            return new PythonMedia();
        }else if ("golang".equals(mediaType.toLowerCase())){
            return new GolangMedia();
        }
        return null;
    }

}
