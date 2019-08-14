package com.jinm.learning.design.pattern.structural.proxy;

/**
 * order dao implements.
 * Created by jinm on  2019/08/14.  contact: keanemer.gmail.com
 */

public class OrderDaoImpl implements IOrderDao {
    @Override
    public int saveOrder(Order order) {
        //模拟数据库操作
        System.out.println("Dao 层添加 Order 成功");
        return 1;
    }
}
