package com.jinm.learning.design.pattern.structural.decorator.v1;

/**
 * test.
 * Created by jinm on  2019/08/04.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  继承的方式扩展类的功能
         *      缺点：如果有一个人需要加两个鸡蛋，两根香肠，当前继承的方式如果需要实现这个需求就必须再写几个继承类；
         *                如果需要加更多的鸡蛋和香肠，就要加很多个继承子类，显然这样做是不合理的；
         */

        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getDesc() + " 销售价格：" + batterCake.cost());

        BatterCakeWithEgg batterCakeWithEgg = new BatterCakeWithEgg();
        System.out.println(batterCakeWithEgg.getDesc() + " 销售价格：" + batterCakeWithEgg.cost());

        BatterCakeWithEggSausage batterCakeWithEggSausage = new BatterCakeWithEggSausage();
        System.out.println(batterCakeWithEggSausage.getDesc() + " 销售价格：" + batterCakeWithEggSausage.cost());

    }

}
