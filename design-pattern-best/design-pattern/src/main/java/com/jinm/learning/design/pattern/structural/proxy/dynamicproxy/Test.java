package com.jinm.learning.design.pattern.structural.proxy.dynamicproxy;

import com.jinm.learning.design.pattern.structural.proxy.IOrderService;
import com.jinm.learning.design.pattern.structural.proxy.Order;
import com.jinm.learning.design.pattern.structural.proxy.OrderServiceImpl;
import com.jinm.learning.design.pattern.structural.proxy.staticproxy.OrderServiceStaticProxy;

/**
 * dynamic  proxy   test.
 * Created by jinm on  2019/08/15.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Order order = new Order();
        order.setUserId(1);

        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).build();
        orderServiceDynamicProxy.saveOrder(order);

    }

}
