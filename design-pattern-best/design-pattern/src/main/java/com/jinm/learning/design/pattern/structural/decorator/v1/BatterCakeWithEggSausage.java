package com.jinm.learning.design.pattern.structural.decorator.v1;

/**
 * batter cake with egg and suasage.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class BatterCakeWithEggSausage extends BatterCakeWithEgg{

    /**
     *  即加鸡蛋又加香肠的煎饼
     */
    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
