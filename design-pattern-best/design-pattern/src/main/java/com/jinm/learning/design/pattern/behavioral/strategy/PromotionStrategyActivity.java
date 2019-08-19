package com.jinm.learning.design.pattern.behavioral.strategy;

/**
 * promotion strategy activity.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class PromotionStrategyActivity {

    /**
     *  业务侧促销活动
     *  场景：
     *      某网上商城不同类型的促销活动
     */

    private PromotionStrategy promotionStrategy;

    public PromotionStrategyActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotion(){
        promotionStrategy.doPromotion();
    }

}
