package com.jinm.pattern.proxy.dynamic.jdk.customize.proxy;

import java.lang.reflect.*;

public class $Proxy0 implements com.jinm.pattern.proxy.dynamic.jdk.customize.IPerson {
    CustomizeInvocationHandler h;

    public $Proxy0(CustomizeInvocationHandler h) {
        this.h = h;
    }

    public void findLove() {
        try {
            Method m = com.jinm.pattern.proxy.dynamic.jdk.customize.IPerson.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }

    }

    public void insure() {
        try {
            Method m = com.jinm.pattern.proxy.dynamic.jdk.customize.IPerson.class.getMethod("insure", new Class[]{});
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }

    }
}
