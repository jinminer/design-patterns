package com.jinm.learning.design.pattern.creational.singleton.container;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * container singleton.
 * Created by jinm on  2019/08/01.  contact: keanemer.gmail.com
 */

public class ContainerSingleton {

//    private static HashMap<String, Object> container = new HashMap<>();
//    private static Hashtable<String, Object> container = new Hashtable<>();
    private static ConcurrentHashMap<String, Object> container = new ConcurrentHashMap<>();

    private ContainerSingleton(){

    }

    public static void putInstance(String key, Object value){

        /**
         *  双重检查锁确保单例
         */
        if (!container.containsKey(key)){

            synchronized (ContainerSingleton.class){
                if (StringUtils.isNotBlank(key) && value != null){
                    if (!container.containsKey(key)){
                        container.put(key, value);
                    }
                }
            }

        }

    }

    public static Object getInstance(String key){
        return container.get(key);
    }

}
