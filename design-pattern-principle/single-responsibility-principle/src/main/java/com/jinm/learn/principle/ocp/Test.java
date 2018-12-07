package com.jinm.learn.principle.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinm on  2018/12/02.
 */

public class Test {

    public static void main(String[] args) {
        Shape s = new Triangle();
        test(s);
    }

    private static void test(Shape s) {
        s.draw();
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("3");
//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i);
//        }
    }

}
