package com.jinm.learning.design.pattern.behavioral.interpretor;

/**
 * test.
 * Created by jinm on  2019/08/20.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  计算   (999  + 888) * 666 表达式的结果
         */
        String inputStr = "666 999 888 + *";
        MyExpressionParser expressionParser = new MyExpressionParser();
        int result = expressionParser.parse(inputStr);
        System.out.println("解释器计算结果：" + result);

    }

}
