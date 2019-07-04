package com.jinm.design.principle.singleresponsibility.calsslevelsingle.general;

/**
 * bird.
 * Created by jinm on  2019/07/04.  contact: keanemer.gmail.com
 */

public class Bird {

    /**
     *  鸟类移动方法
     */
    public void mainMoveMode(String birdName){
        System.out.println(birdName + "用翅膀飞");
    }

    /**
     *  if-else分支进行职责区分处理（实际开发中最常用的方法）
     */
    public void mainMoveModeWithJudge(String birdName){

        if ("鸿雁".equals(birdName)){
            System.out.println(birdName + "用脚走");
        }else if ("企鹅".equals(birdName)){
            System.out.println(birdName + "在水里游");
        }else {
            System.out.println(birdName + "用翅膀飞");
        }

    }

}
