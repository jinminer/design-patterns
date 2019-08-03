package com.jinm.learning.design.pattern.structural.facade;

/**
 * client.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class Client {

    public static void main(String[] args) {

        PointsGift gift = new PointsGift();
        gift.setName("T恤");
        GiftExchangeService service = new GiftExchangeService();
        service.giftExchange(gift);

    }

}
