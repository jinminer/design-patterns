package com.jinm.learning.design.pattern.structural.decorator.v1;

/**
 * batter cake with egg.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class BatterCakeWithEgg extends BatterCake{

    /**
     *  加蛋煎饼
     */
    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
