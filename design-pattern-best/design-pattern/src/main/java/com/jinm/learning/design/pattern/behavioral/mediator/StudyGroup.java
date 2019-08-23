package com.jinm.learning.design.pattern.behavioral.mediator;

import java.util.Date;

/**
 * study group.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class StudyGroup {

    /**
     *  学习交流群：中介者
     */
    public static void showMessage(User user, String message){

        /**
         *  对于message的封装处理也可以在这里进行，不必在每个user中实现，如敏感字、敏感信息的校验等
         */
        System.out.println(new Date().toString() + " [" + user.getName() + "] :" + message);
    }

}
