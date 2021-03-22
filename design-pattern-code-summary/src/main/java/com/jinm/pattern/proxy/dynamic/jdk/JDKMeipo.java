package com.jinm.pattern.proxy.dynamic.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {

    private IPerson person;

    public IPerson getInstance(IPerson person){

        this.person = person;
        Class<?> clazz = person.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

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
