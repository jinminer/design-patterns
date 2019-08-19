package com.jinm.learning.design.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * promotion strategy factory.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class PromotionStrategyFactory {

    /**
     *  策略模式和工厂模式结合使用降低业务层代码量
     */

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LI_JIAN, new ManJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MAN_JIAN, new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FAN_XIAN, new FanXianPromotionStrategy());
    }

    private static final PromotionStrategy non_promotion = new EmptyPromotionStrategy();

    private PromotionStrategyFactory() {

    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? non_promotion : promotionStrategy;
    }

    private interface PromotionKey{

        /**
         *  声明常量，起到逻辑分组的作用
         */
        String LI_JIAN = "LI_JIAN";
        String MAN_JIAN = "MAN_JIAN";
        String FAN_XIAN = "FAN_XIAN";
    }

}
