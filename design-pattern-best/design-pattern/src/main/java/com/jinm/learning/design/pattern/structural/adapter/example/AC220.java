package com.jinm.learning.design.pattern.structural.adapter.example;

/**
 * alternating current 220V.
 * Created by jinm on  2019/08/06.  contact: keanemer.gmail.com
 */

public class AC220 {

    /**
     *  220伏交流电，被适配者
     */

    public int outputAC220V(){
        int output = 220;
        System.out.println("输出交流电 " +output + "V" );
        return output;
    }

}
