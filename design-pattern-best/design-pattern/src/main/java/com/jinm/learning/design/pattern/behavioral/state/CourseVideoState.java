package com.jinm.learning.design.pattern.behavioral.state;

/**
 * course video state.
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public abstract class CourseVideoState {

    /**
     *  课程视频状态
     */

    /**
     *  课程视频上下文：
     *      protected修饰，子类可以获取访问
     */
    protected CourseVideoContext context;

    public void setContext(CourseVideoContext context) {
        this.context = context;
    }

    //播放
    public abstract void play();

    //快进
    public abstract void speed();

    //暂停
    public abstract void pause();

    //停止
    public abstract void stop();

}
