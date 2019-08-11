package com.jinm.learning.design.pattern.structural.bridge;

/**
 * deposit account.
 * Created by jinm on  2019/08/12.  contact: keanemer.gmail.com
 */

public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
