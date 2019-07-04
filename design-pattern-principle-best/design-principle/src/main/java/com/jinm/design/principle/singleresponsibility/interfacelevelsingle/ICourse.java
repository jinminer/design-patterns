package com.jinm.design.principle.singleresponsibility.interfacelevelsingle;

/**
 * multiple responsibilities interface
 * Created by jinm on  2019/07/05.
 */

public interface ICourse {

    /**
     *  接口级别的反单一职责原则的设计方式
     *
     *  课程接口类包括
     *      课程信息类接口：课程资料-getCourseDocument() 、课程视频-getCourseMedia()
     *      课程管理类接口：课程学习-studyCourse()、退款-refundCourse()
     *   其中退款行为和课程信息方法相互作用：
     *      当某一学员购买课程后，可以获取课程名称和课程视频；
     *      如果一个人进行了退款，那么他就不能获取到课程资料、视频等信息；
     *   显然如果我们将这些职责放在一个接口类中，退款行为发生后，课程信息类行为依然可以正常运行，这显然不切实际
     *
     */

    public String getCourseDocument();

    public byte[] getCourseMedia();

    public String studyCourse();

    public String refundCourse();

}
