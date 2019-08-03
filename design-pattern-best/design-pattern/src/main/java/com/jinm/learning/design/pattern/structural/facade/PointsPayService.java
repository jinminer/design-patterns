package com.jinm.learning.design.pattern.structural.facade;

/**
 * points pay service.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class PointsPayService {

    public boolean pay(PointsGift pointsGift){

        //支付系统扣减积分逻辑
        System.out.println("积分支付" + pointsGift.getName() + " 成功");
        return true;

    }

}
