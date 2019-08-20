package com.jinm.learning.design.pattern.behavioral.interpretor;

import com.sun.javafx.binding.StringFormatter;

import java.util.Stack;

/**
 * expression parser.
 * Created by jinm on  2019/08/20.  contact: keanemer.gmail.com
 */

public class MyExpressionParser {

    private Stack<Interpretor> stack = new Stack<>();

    public int parse(String str){

        String[]  strItemArray = str.split(" ");
        for (String symbol : strItemArray){

            if (!OperatorUtil.isOperator(symbol)){
                Interpretor numberExpression = new NumberInterpretor(symbol);
                stack.push(numberExpression);
                System.out.println(String.format("入栈：%d", numberExpression.interpret()));
            }else {
                //是运算符可以计算
                //运算因子出栈
                Interpretor firstExpression = stack.pop();
                Interpretor secondExpression = stack.pop();
                System.out.println(String.format("出栈：%d 和 %d", firstExpression.interpret(), secondExpression.interpret()));

                //根据运算符类型执行不同的运算解释器
                Interpretor operator = OperatorUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                System.out.println(String.format("应用运算符：%s", operator));
                int result = operator.interpret();

                //数字解释器解析阶段计算结果，并将该运算结果入栈
                NumberInterpretor resultExpression = new NumberInterpretor(result);
                stack.push(resultExpression);
                System.out.println(String.format("阶段计算结果入栈：%d", resultExpression.interpret()));

            }

        }

        //最终结果出栈并返回
        int result = stack.pop().interpret();
        return result;

    }

}
