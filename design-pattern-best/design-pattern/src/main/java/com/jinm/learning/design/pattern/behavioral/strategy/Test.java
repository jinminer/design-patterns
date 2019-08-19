package com.jinm.learning.design.pattern.behavioral.strategy;

import org.apache.commons.lang3.StringUtils;

/**
 * test.
 * Created by jinm on  2019/08/19.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

//        /**
//         *  策略模式实现：应用层选择哪个策略，哪个策略内部的促销逻辑就被执行，而应用层并不知道具体的实现内容
//         *  传统的if-else实现：应用层要将各个促销策略中的实现逻辑都通过if-else逻辑串联在一起，代码耦合度高，并且会使方法过于臃肿，不利于以后的维护扩展
//         */
//        PromotionStrategyActivity activity618 = new PromotionStrategyActivity(new FanXianPromotionStrategy());
//        activity618.executePromotion();
//        PromotionStrategyActivity activity1111 = new PromotionStrategyActivity(new ManJianPromotionStrategy());
//        activity1111.executePromotion();
//        PromotionStrategyActivity activity0000 = new PromotionStrategyActivity(new LiJianPromotionStrategy());
//        activity1111.executePromotion();

//        /**
//         *  缺点：
//         *      对于业务层来讲这种简版的策略模式，每调用一个促销活动都要new 一个活动和相应的策略；
//         *      并且没有完全消除if-else逻辑
//         */
//        PromotionStrategyActivity activity = null;
//        String promotionKey = "LI_JIAN";
//        if (StringUtils.equals(promotionKey, "LI_JIAN")){
//            activity = new PromotionStrategyActivity(new LiJianPromotionStrategy());
//        }else if (StringUtils.equals(promotionKey, "MAN_JIAN")){
//            activity = new PromotionStrategyActivity(new ManJianPromotionStrategy());
//        }//......
//
//        activity.executePromotion();

        /**
         *  工厂模式-策略模式结合使用：减少业务层代码量
         */
        String promotionKey = "LI_JIAN";
        PromotionStrategyActivity activity = new PromotionStrategyActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.executePromotion();

    }

}
