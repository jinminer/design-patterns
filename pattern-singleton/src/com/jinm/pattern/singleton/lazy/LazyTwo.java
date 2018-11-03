package com.jinm.pattern.singleton.lazy;

/**
 * Created by jinm on  2018/10/25.
 */

public class LazyTwo {

    private LazyTwo(){

    }

    private static LazyTwo lazy = null;

    public static synchronized LazyTwo getInstance(){
        if (lazy == null) {
            lazy = new LazyTwo();
        }

        return lazy;

    }

}
