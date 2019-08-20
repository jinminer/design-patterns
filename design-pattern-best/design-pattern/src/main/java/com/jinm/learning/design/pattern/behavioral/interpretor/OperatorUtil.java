package com.jinm.learning.design.pattern.behavioral.interpretor;

/**
 * .
 * Created by jinm on  2019/08/20.  contact: keanemer.gmail.com
 */

public class OperatorUtil {

    /**
     *  判断字符是否为运算符
     */
    public static boolean isOperator(String symbol) {
        return ("+".equals(symbol) || "*".equals(symbol));
    }

    /**
     *  加法运算    --->     返回新的加法解释器
     *  乘法运算    --->    返回新的乘法解释器
     */
    public static Interpretor getExpressionObject(Interpretor firstExpression, Interpretor secondExpression, String symbol) {
        if ("+".equals(symbol)){
            return new AddInterpretor(firstExpression, secondExpression);
        }else if ("*".equals(symbol)){
            return new MultiInterpretor(firstExpression, secondExpression);
        }

        return null;
    }
}
