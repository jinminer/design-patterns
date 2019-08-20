package com.jinm.learning.design.pattern.behavioral.interpretor;

/**
 * number interpretor.
 * Created by jinm on  2019/08/20.  contact: keanemer.gmail.com
 */

public class NumberInterpretor implements Interpretor {

    /**
     *  加法运算的运算因子表达式
     *  并不进行实际的运算，只是做一个类型转换；
     *  实现Interpretor接口是为了字符表达式进行统一处理，在MyExpressionParser类中统一调用接口通用方法interpret()
     */
    private int number;

    public NumberInterpretor(int number) {
        this.number = number;
    }

    public NumberInterpretor(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return number;
    }

    @Override
    public String toString() {
        return "+";
    }
}
