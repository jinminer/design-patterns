package com.jinm.learning.design.pattern.structural.decorator.v2;

/**
 * abstract decorator.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public abstract class AbstractDecorator extends ABatterCake {

    private ABatterCake aBatterCake;

    /**
     *  建立煎饼装饰类AbstractDecorator和ABatterCake煎饼之间的关系：
     *  通过构造器将抽象煎饼注入到装饰类中，这样抽象煎饼的实现类BatterCake和抽象装饰类AbstractDecorator的扩展子类之间就会相互关联，
     *  在调用装饰器AbstractDecorator时，实际上通过构造器是把它委托给了抽象煎饼ABatterCake，来处理煎饼相应的业务
     */
    public AbstractDecorator(ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    /**
     *  如果装饰器子类有必须要实现的方法，即可定义装饰器抽象类，并定义该抽象方法
     */
    public abstract String doSomething();

    @Override
    protected String getDesc() {
        return aBatterCake.getDesc();
    }

    @Override
    protected int cost() {
        return aBatterCake.cost();
    }

}
