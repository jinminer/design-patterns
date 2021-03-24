package com.jinm.pattern.proxy.dynamic.jdk.customize.client;


import com.jinm.pattern.proxy.dynamic.jdk.customize.proxy.CustomProxy;
import com.jinm.pattern.proxy.dynamic.jdk.customize.proxy.CustomizeClassLoader;
import com.jinm.pattern.proxy.dynamic.jdk.customize.proxy.CustomizeInvocationHandler;
import com.jinm.pattern.proxy.dynamic.jdk.customize.IPerson;

import java.lang.reflect.Method;

public class CustomizeJDKMeipo implements CustomizeInvocationHandler {

    private IPerson person;

    public IPerson getInstance(IPerson person){

        this.person = person;
        Class<?> clazz = person.getClass();
        return (IPerson) CustomProxy.newProxyInstance(new CustomizeClassLoader(), clazz.getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.person, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("媒婆：介绍相亲对象吃饭");
    }

    private void before() {

        System.out.println("媒婆：开始物色人选");

    }
}
