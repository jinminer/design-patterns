package com.jinm.learning.design.pattern.structural.bridge;

import java.util.Random;

/**
 * .
 * Created by jinm on  2019/08/12.  contact: keanemer.gmail.com
 */

public class Test1 {

    public static void main(String[] args) {
        Random rnd = new Random();
        boolean toBe = rnd.nextBoolean();
        Number result = (toBe || !toBe) ?
                new Integer(3) : new Float(1);
        System.out.println(result);
    }

}
