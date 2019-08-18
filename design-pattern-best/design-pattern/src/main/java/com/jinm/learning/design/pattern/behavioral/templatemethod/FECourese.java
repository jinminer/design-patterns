package com.jinm.learning.design.pattern.behavioral.templatemethod;

/**
 * front end course.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

/**
 *  前端课程
 */
public class FECourese extends ACourse {

    /**
     *  场景：
     *      对于前端课程，可能包括：vue、react、angularjs等具体类型的课程；
     *      如果其中的react课程需要编写课程笔记，而且其他课程不需要编写；
     *      这时就需要对应用层客户端开放是否编写课程笔记的控制权限，以处理这些个性化差异
     */
    private boolean needWriteArticleFlag = false;

    /**
     *  构造器注入行为控制权限，也可用set方法注入
     */
    public FECourese(boolean needWriteArticleFlag) {
        this.needWriteArticleFlag = needWriteArticleFlag;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticleFlag;
    }

    @Override
    void packageCourse() {

        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体资料");

    }

}
