package com.jinm.pattern.flyweight.ticket;

import java.util.Random;

public class TrainTicket implements Iticket{

    private String from;

    private String to;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        int price = new Random().nextInt(500);
        System.out.println("   " + from + " -> " + to + "：" + bunk + "价格: " + price + "元" );
    }
}
