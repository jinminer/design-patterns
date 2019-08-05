package com.jinm.learning.design.pattern.structural.adapter.example;

/**
 * test.
 * Created by jinm on  2019/08/06.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  场景：
         *      手机充电器将家庭电压 220V 交流电，适配为手机充电电压 5V 直流电
         */
        DC5 adapterDC5 = new PowerAdapter();
        adapterDC5.outputDC5V();

    }

}
