package com.jinm.learning.design.pattern.structural.proxy;

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
     *  增强目标对象orderService 的 saveOrder 行为
     */
    public int saveOrder(Order order){
        beforeMethod();

        //显示注入，模拟spring注入
        orderService = new OrderServiceImpl();
        int userId = order.getUserId();
        //设置分库分表路由规则
        int dbRouter = userId %2;
        System.out.println("静态代理分配到 db【" + dbRouter + "】处理数据");

        afterMethod();
        return 0;
    }

    private void beforeMethod(){
        System.out.println("静态代理    before  code");
    }

    private void afterMethod(){
        System.out.println("静态代理    after   code");
    }

}
