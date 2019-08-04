package com.jinm.learning.design.pattern.structural.decorator.v1;

/**
 * batter cake.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class BatterCake {

    /**
     *  场景：路边小摊卖煎饼，煎饼加鸡蛋、加香肠并计算价格
     */
    protected String getDesc(){
        return "煎饼";
    }

    protected int cost(){
        return 5;
    }

}
