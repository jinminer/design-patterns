package com.jinm.learning.design.pattern.behavioral.strategy;

/**
 * empty promotion strategy.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class EmptyPromotionStrategy implements PromotionStrategy {

    /**
     *  空处理：无促销活动
     */
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
