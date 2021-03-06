package com.jinm.learning.design.pattern.structural.proxy.staticproxy;

import com.jinm.learning.design.pattern.structural.proxy.Order;
import com.jinm.learning.design.pattern.structural.proxy.staticproxy.OrderServiceStaticProxy;

/**
 * static   proxy   test.
 * Created by jinm on  2019/08/15.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Order order = new Order();
        order.setUserId(1);

        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        proxy.saveOrder(order);

    }

}
