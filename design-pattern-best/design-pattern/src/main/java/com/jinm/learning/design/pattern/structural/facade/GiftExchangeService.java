package com.jinm.learning.design.pattern.structural.facade;

/**
 * gift exchange service.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class GiftExchangeService {

    //信息校验服务
    private QualifyService qualifyService = new QualifyService();

    //积分支付服务
    private PointsPayService pointsPayService = new PointsPayService();

    //物流服务
    private ShippingService shippingService = new ShippingService();

    /**
     *  外观类为客户端提供的积分商户兑换方法，
     *  客户端不需要直接与信息校验子系统、积分支付子系统、物流系统进行交互
     *  客户端只需要调用外观类中暴露的方法即可
     */
    public void giftExchange(PointsGift gift){

        if (!qualifyService.isAvailable(gift)){
            System.out.println("信息校验失败");
            return;
        }

        if (!pointsPayService.pay(gift)){
            System.out.println("积分支付失败");
            return;
        }

        String orderNo = shippingService.shipping(gift);
        System.out.println("积分兑换成功，商品：" + gift.getName() + "物流订单号：" + orderNo);


    }

}
