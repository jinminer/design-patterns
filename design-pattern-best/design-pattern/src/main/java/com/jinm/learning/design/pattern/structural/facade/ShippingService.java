package com.jinm.learning.design.pattern.structural.facade;

/**
 * shipping service.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class ShippingService {

    public String shipping(PointsGift pointsGift){

        //物流系统对接逻辑
        System.out.println(pointsGift.getName() + " 进入物流系统");
        String shippingOrderNo = "8848";
        return shippingOrderNo;

    }

}
