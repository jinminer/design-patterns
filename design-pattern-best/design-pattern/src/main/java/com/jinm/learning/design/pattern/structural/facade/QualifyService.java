package com.jinm.learning.design.pattern.structural.facade;

/**
 * qualify service.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class QualifyService {

    public boolean isAvailable(PointsGift pointsGift){

        //信息校验逻辑
        System.out.println("校验" + pointsGift.getName() + " 积分资格校验通过，库存校验通过");
        return true;

    }

}
