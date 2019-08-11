package com.jinm.learning.design.pattern.structural.bridge;

/**
 * ABC bank.
 * Created by jinm on  2019/08/12.  contact: keanemer.gmail.com
 */

public class ABCBank extends Bank {

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("打开中国农业银行账号");

        /**
         *  将Bank实现类的openAccount行为委托给Acount实现类的openAccount去做
         */
        account.openAccount();

        return account;
    }
}
