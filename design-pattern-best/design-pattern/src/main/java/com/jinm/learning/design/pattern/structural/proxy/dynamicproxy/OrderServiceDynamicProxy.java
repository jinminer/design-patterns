package com.jinm.learning.design.pattern.structural.proxy.dynamicproxy;

import com.jinm.learning.design.pattern.structural.proxy.Order;
import com.jinm.learning.design.pattern.structural.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * order service dynamic proxy.
 * Created by jinm on  2019/08/15.  contact: keanemer.gmail.com
 */

public class OrderServiceDynamicProxy implements InvocationHandler {

    //要被代理的目标对象
    private Object target;

    //构造器注入被代理的目标对象
    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object build(){
        Class clazz = target.getClass();

        //动态代理的核心
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
      * Create by jinm on 2019/8/15 .
      * @description    动态代理
      * @param proxy    一般很少使用，被调用方法的代理实例
      * @param method   要被增强的方法对象
      * @param args 被增强方法的参数
      * @return java.lang.Object
      */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object arg = args[0];
        beforeMethod(arg);
        Object object = method.invoke(target, args);
        afterMethod();

        return object;
    }

    private void beforeMethod(Object obj){

        System.out.println("动态代理    before  code");

        if (obj instanceof Order){
            /*-----------------------被代理目标对象方法增强    begining---------------------------*/
            Order order = (Order) obj;
            int userId = order.getUserId();
            //设置分库分表路由规则
            int dbRouter = userId %2;
            System.out.println("动态代理分配到 db【" + dbRouter + "】处理数据");

            //TODO 设置datasource
            DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
            /*-----------------------被代理目标对象方法增强    ending---------------------------*/
        }

    }

    private void afterMethod(){
        System.out.println("动态代理    after   code");
    }

}
