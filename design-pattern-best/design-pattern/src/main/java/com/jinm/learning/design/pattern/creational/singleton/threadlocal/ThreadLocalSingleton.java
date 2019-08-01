package com.jinm.learning.design.pattern.creational.singleton.threadlocal;

/**
 * thread local singleton.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class ThreadLocalSingleton {

    public static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton(){

    }

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }

}
