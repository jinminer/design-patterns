package com.jinm.design.principle.singleresponsibility.interfacelevelsingle;

/**
 * content course implement.
 * Created by jinm on  2019/07/05.  contact: keanemer.gmail.com
 */

public class ContentCourse implements IContentCourse{

    @Override
    public String getCourseDocument() {
        return null;
    }

    @Override
    public byte[] getCourseMedia() {
        return new byte[0];
    }

}
