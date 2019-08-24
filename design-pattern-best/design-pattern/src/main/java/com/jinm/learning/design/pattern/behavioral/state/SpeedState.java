package com.jinm.learning.design.pattern.behavioral.state;

/**
 * speed state.
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public class SpeedState extends CourseVideoState{

    /**
     *  切换到播放，快进状态可以切换到正常播放状态
     */
    @Override
    public void play() {
        super.context.setState(CourseVideoContext.PLAY_STATE);
    }

    /**
     *  当前状态
     */
    @Override
    public void speed() {
        System.out.println("快进播放视频课程状态");
    }

    /**
     *  切换到暂停，快进状态可以切换到暂停状态
     */
    @Override
    public void pause() {
        super.context.setState(CourseVideoContext.PAUSE_STATE);
    }

    /**
     *  切换到停止，快进状态可以切换到停止状态
     */
    @Override
    public void stop() {
        super.context.setState(CourseVideoContext.STOP_STATE);
    }

}
