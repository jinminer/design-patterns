package com.jinm.design.principle.singleresponsibility.interfacelevelsingle;

/**
 * single responsibilities interface
 * Created by jinm on  2019/07/05.
 */

public interface IManageCourse {

    /**
     *  接口级别的单一职责原则的设计方式
     *
     *  课程管理类接口：课程学习-studyCourse()、退款-refundCourse()
     *  这个接口只关心课程管理相关的问题
     */

    public String studyCourse();

    public String refundCourse();

}
