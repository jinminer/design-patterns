package com.jinm.design.principle.singleresponsibility.interfacelevelsingle;

/**
 * single responsibilities interface
 * Created by jinm on  2019/07/05.
 */

public interface IContentCourse {

    /**
     *  接口级别的单一职责原则的设计方式
     *
     *  课程信息接口类包括：课程资料-getCourseDocument() 、课程视频-getCourseMedia()
     *  这个接口类只关心课程内容相关的问题
     *
     */

    public String getCourseDocument();

    public byte[] getCourseMedia();

}
