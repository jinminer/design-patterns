package com.jinm.learning.design.pattern.structural.decorator.v2;

/**
 * sausage decorator.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(ABatterCake abatterCake) {
        super(abatterCake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }

    @Override
    public String doSomething() {
        return null;
    }

}
