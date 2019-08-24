package com.jinm.learning.design.pattern.behavioral.state;

/**
 * pause state.
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public class PauseState extends CourseVideoState{

    /**
     *  切换到播放，暂停状态可以切换到播放状态
     */
    @Override
    public void play() {
        super.context.setState(CourseVideoContext.PLAY_STATE);
    }

    /**
     *  切换到快进，暂停状态可以切换到快进状态
     */
    @Override
    public void speed() {
        super.context.setState(CourseVideoContext.SPEED_STATE);
    }

    /**
     *  当前状态
     */
    @Override
    public void pause() {
        System.out.println("暂停播放视频课程状态");
    }

    /**
     *  切换到停止，暂停状态可以切换到停止状态
     */
    @Override
    public void stop() {
        super.context.setState(CourseVideoContext.STOP_STATE);
    }

}
