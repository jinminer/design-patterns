package com.jinm.learning.design.pattern.behavioral.strategy;

/**
 * li jian promotion strategy.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class LiJianPromotionStrategy implements PromotionStrategy {

    /**
     *  立减促销
     */
    @Override
    public void doPromotion() {
        System.out.println("立减促销，商品的价格直接减去系统配置的价格");
    }

}

