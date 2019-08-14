package com.jinm.learning.design.pattern.structural.proxy;

/**
 * order.
 * Created by jinm on  2019/08/14.  contact: keanemer.gmail.com
 */

public class Order {

    private Object orderInfo;
    private Integer userId;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
