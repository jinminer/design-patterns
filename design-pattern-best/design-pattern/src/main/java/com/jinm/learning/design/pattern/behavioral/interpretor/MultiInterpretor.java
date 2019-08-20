package com.jinm.learning.design.pattern.behavioral.interpretor;

/**
 * multi interpretor.
 * Created by jinm on  2019/08/20.  contact: keanemer.gmail.com
 */

public class MultiInterpretor implements Interpretor {

    /**
     *  乘法运算的运算因子表达式
     */
    private Interpretor firstExpression;
    private Interpretor secondExpression;

    public MultiInterpretor(Interpretor firstExpression, Interpretor secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() * this.secondExpression.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}
