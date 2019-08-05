package com.jinm.learning.design.pattern.structural.adapter.example;

/**
 * power adapter.
 * Created by jinm on  2019/08/06.  contact: keanemer.gmail.com
 */

public class PowerAdapter implements DC5 {

    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5V() {

        //类组合的模式实现适配器
        int adapterInput = ac220.outputAC220V();

        //适配逻辑：变压器......
        int adapterOutput = adapterInput/44;
        System.out.println("使用PowerAdapter输入AC: " + adapterInput + "V ---> 输出DC: " + adapterOutput + "V");

        return adapterOutput;
    }

}
