package com.jinm.learning.design.pattern.structural.decorator.v2;

/**
 * egg decorator.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class EggDecorator extends AbstractDecorator {

    public EggDecorator(ABatterCake abatterCake) {
        super(abatterCake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }

    @Override
    public String doSomething() {
        return null;
    }

}
