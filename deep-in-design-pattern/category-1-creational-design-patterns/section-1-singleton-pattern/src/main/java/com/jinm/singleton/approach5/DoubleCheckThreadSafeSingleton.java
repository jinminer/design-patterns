package com.jinm.singleton.approach5;

public class DoubleCheckThreadSafeSingleton {

    private static DoubleCheckThreadSafeSingleton instance;

    private DoubleCheckThreadSafeSingleton(){

    }

    private static synchronized DoubleCheckThreadSafeSingleton getInstance(){

        if (instance == null){

            synchronized (DoubleCheckThreadSafeSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckThreadSafeSingleton();
                }

            }

        }

        return instance;

    }

}
