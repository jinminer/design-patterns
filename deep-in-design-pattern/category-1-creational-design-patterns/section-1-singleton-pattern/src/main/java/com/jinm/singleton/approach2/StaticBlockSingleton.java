package com.jinm.singleton.approach2;

import com.jinm.singleton.approach1.EagerInitializedSingleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){

    }

    static {

        try {
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }

}
