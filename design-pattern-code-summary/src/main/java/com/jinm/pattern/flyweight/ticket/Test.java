package com.jinm.pattern.flyweight.ticket;

public class Test {

    public static void main(String[] args) {

        Iticket ticket = TicketFactory.getTicket("北京西", "兰州西");
        ticket.showInfo("硬座");

        ticket = TicketFactory.getTicket("北京西", "兰州西");
        ticket.showInfo("软卧");

        ticket = TicketFactory.getTicket("北京西", "兰州");
        ticket.showInfo("硬卧");

    }

}
