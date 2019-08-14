package com.jinm.learning.design.pattern.structural.proxy.staticproxy;

import com.jinm.learning.design.pattern.structural.proxy.IOrderService;
import com.jinm.learning.design.pattern.structural.proxy.Order;
import com.jinm.learning.design.pattern.structural.proxy.OrderServiceImpl;
import com.jinm.learning.design.pattern.structural.proxy.db.DataSourceContextHolder;

/**
 * order service static proxy.
 * Created by jinm on  2019/08/14.  contact: keanemer.gmail.com
 */

public class OrderServiceStaticProxy {

    /**
     *  声明/注入目标对象
     */
    private IOrderService orderService;

    /**
     *  增强目标对象orderService 的 saveOrder 行为;
     *  这里的方法命名可以与被增强的目标对象方法相同，也可不同
     */
    public int saveOrder(Order order){
        beforeMethod();

        //显示注入，模拟spring注入
        orderService = new OrderServiceImpl();
        int userId = order.getUserId();
        //设置分库分表路由规则
        int dbRouter = userId %2;
        System.out.println("静态代理分配到 db【" + dbRouter + "】处理数据");

        //TODO 设置datasource
        DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));

        afterMethod();
        return orderService.saveOrder(order);
    }

    private void beforeMethod(){
        System.out.println("静态代理    before  code");
    }

    private void afterMethod(){
        System.out.println("静态代理    after   code");
    }

}
