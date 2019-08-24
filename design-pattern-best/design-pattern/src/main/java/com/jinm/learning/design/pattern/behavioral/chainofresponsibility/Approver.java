package com.jinm.learning.design.pattern.behavioral.chainofresponsibility;

/**
 * approver.
 * Created by jinm on  2019/08/24.  contact: keanemer.gmail.com
 */

public abstract class Approver {

    /**
     *  课程审批者：
     */

    /**
     *  责任链模式中的审批者类中要声明一个自己类型的审批者；
     *  在某些源码中使用的时Handler这种写法，作用时相同的；
     *  声明了它自己的一个对象，这里要注意使用this关键字时，对象到底时哪一个；
     *  protected修饰，子类可以获取该属性；
     */
    protected Approver approver;

    /**
     *  设置链条中的下一个处理对象
     */
    public void setNextApprover(Approver approver){
        this.approver = approver;
    }

    /**
     *  发布课程的行为，声明为abstract型，交由子类去实现，不同子类的实现不同
     */
    public abstract void deploy(Course course);

}
