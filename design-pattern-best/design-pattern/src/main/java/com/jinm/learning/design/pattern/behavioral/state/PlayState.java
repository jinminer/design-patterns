package com.jinm.learning.design.pattern.behavioral.state;

/**
 * play state.
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public class PlayState extends CourseVideoState {

    /**
     *  当前状态
     */
    @Override
    public void play() {
        System.out.println("正常播放视频课程状态");
    }

    /**
     *  切换到快进，播放状态可以切换到快进状态
     */
    @Override
    public void speed() {
        super.context.setState(CourseVideoContext.SPEED_STATE);
    }

    /**
     *  切换到暂停，播放状态可以切换到暂停状态
     */
    @Override
    public void pause() {
        super.context.setState(CourseVideoContext.PAUSE_STATE);
    }

    /**
     *  切换到停止，播放状态可以切换到停止状态
     */
    @Override
    public void stop() {
        super.context.setState(CourseVideoContext.STOP_STATE);
    }

}
