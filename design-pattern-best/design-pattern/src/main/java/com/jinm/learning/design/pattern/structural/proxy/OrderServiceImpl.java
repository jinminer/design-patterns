package com.jinm.learning.design.pattern.structural.proxy;

/**
 * order service implements.
 * Created by jinm on  2019/08/14.  contact: keanemer.gmail.com
 */

public class OrderServiceImpl implements IOrderService {

    private IOrderDao orderDao;

    @Override
    public int saveOrder(Order order) {

        //这里显示声明，模拟spring注入
        orderDao = new OrderDaoImpl();
        System.out.println("Service 层调用Dao层添加 Order");
        return orderDao.saveOrder(order);
    }

}
