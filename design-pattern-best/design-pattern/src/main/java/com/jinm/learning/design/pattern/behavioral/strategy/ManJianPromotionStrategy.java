package com.jinm.learning.design.pattern.behavioral.strategy;

/**
 * man jian promotion strategy.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class ManJianPromotionStrategy implements PromotionStrategy{

    /**
     *  满减促销
     */
    @Override
    public void doPromotion() {
        System.out.println("满减促销，满900-300元");
    }

}
