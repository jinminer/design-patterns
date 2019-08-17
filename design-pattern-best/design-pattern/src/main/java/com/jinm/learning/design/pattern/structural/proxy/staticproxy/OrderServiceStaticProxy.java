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

        /**
         *  这里要注意beforeMethod()方法和afterMethod()方法的界限划分
         *      代理类中的方法OrderServiceStaticProxy.saveOrder()  是为了增强 目标对象的方法orderService.saveOrder()：
         *          beforeMethod()：确定目标数据库，在执行orderService.saveOrder()之前要完成对分库分表的数据库路由选择逻辑，即确定数据要插入哪个库；
         *          afterMethod()：在执行orderService.saveOrder()完毕之后需要完成的逻辑；
         */

        /**
         *  具体的代理处理逻辑
         *  即，在目标对象的saveOrder()方法被调用之前，数据要插入哪个库已经确定
         */
        beforeMethod(order);

        //显示注入，模拟spring注入
        orderService = new OrderServiceImpl();

        //被代理的目标对象的方法，也就是目标对象被实际增强的方法
        int result = orderService.saveOrder(order);

        afterMethod();

        return result;
    }

    private void beforeMethod(Order order){

        System.out.println("静态代理    before  code");

        /*-----------------------被代理目标对象方法增强    begining---------------------------*/
        int userId = order.getUserId();
        //设置分库分表路由规则
        int dbRouter = userId %2;
        System.out.println("静态代理分配到 db【" + dbRouter + "】处理数据");

        //TODO 设置datasource
        DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
        /*-----------------------被代理目标对象方法增强    ending---------------------------*/

    }

    private void afterMethod(){
        System.out.println("静态代理    after   code");
    }

}
