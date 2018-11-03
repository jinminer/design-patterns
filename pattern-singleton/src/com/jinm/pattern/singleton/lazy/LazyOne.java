package com.jinm.pattern.singleton.lazy;

/**
 * Created by jinm on  2018/10/25.
 */

public class LazyOne {

    private LazyOne(){

    }

    private static LazyOne lazy = null;

    public static LazyOne getInstance(){
        if (lazy == null) {
            lazy = new LazyOne();
        }

        return lazy;

    }

}
