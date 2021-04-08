package com.jinm.pattern.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {

    private static Map<String, Iticket> pool = new ConcurrentHashMap<>();

    public static Iticket getTicket(String from, String to){

        String key  = from + "-" + to;
        if (pool.containsKey(key)){
            System.out.println("使用缓存：" + key);
            return pool.get(key);
        }

        System.out.println("首次查询，创建对象：" + key);
        Iticket ticket = new TrainTicket(from, to);
        pool.put(key, ticket);

        return ticket;
    }

}
