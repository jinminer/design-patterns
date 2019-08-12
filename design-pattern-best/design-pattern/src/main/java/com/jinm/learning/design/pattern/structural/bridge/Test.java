package com.jinm.learning.design.pattern.structural.bridge;

/**
 * test.
 * Created by jinm on  2019/08/12.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Bank abcBank = new ABCBank(new DepositAccount());
        Account depositAccount = abcBank.openAccount();
        depositAccount.showAccountType();
        System.out.println("------------------------------------");


        Bank icbcBank = new ICBCBank(new SavingAccount());
        Account savingAccount = icbcBank.openAccount();;
        savingAccount.showAccountType();
        System.out.println("------------------------------------");

        Bank abcBank1 = new ABCBank(new DepositAccount());
        Account depositAccount1 = abcBank1.openAccount();
        depositAccount1.showAccountType();

    }

}
