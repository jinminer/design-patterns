package com.jinm.pattern.proxy.dynamic.cglib;


import com.jinm.pattern.proxy.dynamic.jdk.IPerson;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.omg.PortableInterceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CglibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();

    }


    private void after() {
        System.out.println("媒婆：介绍相亲对象吃饭");
    }

    private void before() {

        System.out.println("媒婆：开始物色人选");

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        before();

        Object result = methodProxy.invokeSuper(o, objects);

        after();

        return result;
    }
}
