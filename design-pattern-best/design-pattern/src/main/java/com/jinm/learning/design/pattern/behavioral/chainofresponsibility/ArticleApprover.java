package com.jinm.learning.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 *  course article approver.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public class ArticleApprover extends Approver {

    /**
     *  课程笔记审批者
     */

    /**
     *  发布课程方法实现
     */
    @Override
    public void deploy(Course course) {

        /**
         *  课程笔记校验
         */
        if (StringUtils.isNotEmpty(course.getArticle())){
            System.out.println(course.getName() + "包含笔记，笔记校验通过！批准！！");

            /**
             *  当前链环节处理完成，拿到父类中的审批者对象，并把处理对象交由该对象
             */
            if (approver != null){
                approver.deploy(course);
            }

        }else {
            System.out.println(course.getName() + "不包含笔记，笔记不校验通过！不批准！！流程结束！！！");
            return;
        }


    }

}
