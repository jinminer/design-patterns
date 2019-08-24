package com.jinm.learning.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 *  course video approver.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class VideoApprover extends Approver {

    /**
     *  课程视频审批者
     */

    /**
     *  发布课程方法实现
     */
    @Override
    public void deploy(Course course) {

        /**
         *  课程视频校验
         */
        if (StringUtils.isNotEmpty(course.getVideo())){
            System.out.println(course.getName() + "包含视频，视频校验通过！批准！！");

            /**
             *  当前链环节处理完成，拿到父类中的审批者对象，并把处理对象交由该对象
             */
            if (approver != null){
                approver.deploy(course);
            }

        }else {
            System.out.println(course.getName() + "不包含视频，视频不校验通过！不批准！！流程结束！！！");
            return;
        }


    }

}
