package com.jinm.learning.design.pattern.structural.bridge;

/**
 * abstract bank.
 * Created by jinm on  2019/08/12.  contact: keanemer.gmail.com
 */

public abstract class Bank {

    /**
     *  引入Account类，并把该行为交由子类，所以访问类型为protected
     */
    protected Account account;

    //构造注入Account，也可以使用set方法代替
    public Bank(Account account) {
        this.account = account;
    }

    /**
     *  委托关系：Bank类中的openAccount行为要委托给Account，所以定义该接口；
     *  当然这样方法名不强制要求与Account类一致，只是为了方便理解
     */
    public abstract Account openAccount();
}
