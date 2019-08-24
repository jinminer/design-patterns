package com.jinm.learning.design.pattern.behavioral.state;

/**
 * course video context.
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public class CourseVideoContext {

    /**
     *  课程视频上下文
     */

    //组合课程视频状态
    private CourseVideoState state;

    /**
     *  声明状态:
     *      这里由于各个状态对象并没有属性，所以可以使用享元模式
     */
    public static final PlayState PLAY_STATE = new PlayState();
    public static final SpeedState SPEED_STATE = new SpeedState();
    public static final PauseState PAUSE_STATE = new PauseState();
    public static final StopState STOP_STATE = new StopState();

    public CourseVideoState getState() {
        return state;
    }

    public void setState(CourseVideoState state) {

        /**
         *  设置课程视频状态：状态转换
         */
        this.state = state;

        /**
         *  设置课程视频上下文，即设置它自己;
         *  把当前的上下文(环境)通知到各个状态类
         */
        this.state.setContext(this);

    }

    public void play(){
        this.state.play();
    }

    public void speed(){
        this.state.speed();
    }

    public void pause(){
        this.state.pause();
    }

    public void stop(){
        this.state.stop();
    }

}
