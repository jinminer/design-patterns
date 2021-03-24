package com.jinm.pattern.proxy.dynamic.jdk.customize.proxy;

import java.lang.reflect.Method;

public interface CustomizeInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
