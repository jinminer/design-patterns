package com.jinm.pattern.singleton.lazy;

public class SingletonLazySynchronize {

    private static SingletonLazySynchronize instance;

    private SingletonLazySynchronize(){

    }

    public static synchronized SingletonLazySynchronize getInstance(){

        if (instance  == null) {
            instance = new SingletonLazySynchronize();
        }

        return instance;

    }

}
