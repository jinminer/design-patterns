package com.jinm.singleton.approach4;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){

    }

    private static synchronized ThreadSafeSingleton getInstance(){

        if (instance == null){
            instance = new ThreadSafeSingleton();
        }

        return instance;

    }

}
