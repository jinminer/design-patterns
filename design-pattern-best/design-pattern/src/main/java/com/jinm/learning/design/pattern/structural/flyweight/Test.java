package com.jinm.learning.design.pattern.structural.flyweight;

/**
 * .
 * Created by jinm on  2019/08/08.  contact: keanemer.gmail.com
 */

public class Test {

    private static final String[] DEPARTMENTS = {"RD", "QA", "PM", "BD"};

    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            String department = DEPARTMENTS[(int) (Math.random() * DEPARTMENTS.length)];
//            Manager manager = (Manager) EmployeeFactory.getManager(department);
//            manager.report();
//        }

        integerTest();

    }

    private static void integerTest(){

        Integer a = 100;
        Integer b = Integer.valueOf(100);

        Integer c = 1000;
        Integer d = Integer.valueOf(1000);

        System.out.println("a==b:" + (a == b));
        System.out.println("c==d:" + (c == d));


    }

}
