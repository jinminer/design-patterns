package com.jinm.learning.design.pattern.behavioral.strategy;

/**
 * fan xian promotion strategy.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class FanXianPromotionStrategy implements PromotionStrategy {

    /**
     *  返现促销
     */
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返现的金额存放到用户的账户余额中");
    }

}
