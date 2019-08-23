package com.jinm.learning.design.pattern.behavioral.mediator;

/**
 * test.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        User rose = new User("rose");
        User jack = new User("jack");

        rose.sendMessage("let's learn design pattern");
        jack.sendMessage("ok");

    }

}
