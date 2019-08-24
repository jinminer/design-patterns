package com.jinm.learning.design.pattern.behavioral.state;

/**
 * .
 * Created by jinm on  2019/08/25.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        //声明上下文
        CourseVideoContext context = new CourseVideoContext();

        //初始化课程视频状态：首次打开课程视频网页时为播放状态
        context.setState(CourseVideoContext.PLAY_STATE);

        System.out.println("当前课程视频状态：" + context.getState().getClass().getSimpleName());

        //暂停
        context.pause();

        System.out.println("当前课程视频状态：" + context.getState().getClass().getSimpleName());

        //快进
        context.speed();
        System.out.println("当前课程视频状态：" + context.getState().getClass().getSimpleName());

        //停止
        context.stop();
        System.out.println("当前课程视频状态：" + context.getState().getClass().getSimpleName());

        //在停止状态下进行快进，报错
        context.speed();
    }

}
