package com.jinm.learning.design.pattern.structural.decorator.v2;

/**
 * batter cake.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class BatterCake extends ABatterCake {

    /**
     *  实体煎饼
     */

    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 5;
    }

}
