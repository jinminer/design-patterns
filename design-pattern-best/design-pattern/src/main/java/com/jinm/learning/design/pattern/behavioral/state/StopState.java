package com.jinm.learning.design.pattern.behavioral.state;

/**
 * stop state.
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public class StopState extends CourseVideoState{

    /**
     *  切换到播放，暂停状态可以切换到播放状态
     */
    @Override
    public void play() {
        super.context.setState(CourseVideoContext.PLAY_STATE);
    }

    /**
     *  切换到快进，暂停状态不可以切换到快进状态；
     *      实际开发中可以：抛出异常、不和db交互、向客户端友好提示
     */
    @Override
    public void speed() {
        System.out.println("ERROR：停止状态不能快进！！！");
    }

    /**
     *  切换到暂停，暂停状态不可以切换到暂停状态
     */
    @Override
    public void pause() {
        System.out.println("ERROR：停止状态不能暂停！！！");
    }

    /**
     *  当前状态
     */
    @Override
    public void stop() {
        System.out.println("停止播放视频课程状态");
    }

}
