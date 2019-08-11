package com.jinm.learning.design.pattern.structural.bridge;

/**
 * saving account.
 * Created by jinm on  2019/08/12.  contact: keanemer.gmail.com
 */

public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
