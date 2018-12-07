package com.jinm.pattern.singleton.lazy;

/**
 * Created by jinm on  2018/10/29.
 */

public class LazyThree {

    private LazyThree(){

    }

    public static LazyThree getInstance() {
        return LazyHolder.lazy;
    }

    private static class LazyHolder{
        private static final LazyThree lazy = new LazyThree();
    }


}
