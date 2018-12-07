package com.jinm.learn.principle.srp;

/**
 * Created by jinm on  2018/11/20.
 */

public class Test {

    public static void main(String[] args) {
        getNum(2.3, 3.5);
    }

    private static void getNum(double a, double b){
        System.out.println(a * b);
        throw new UnsupportedOperationException();
    }

}
