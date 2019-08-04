package com.jinm.learning.design.pattern.structural.decorator.v2;

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

        //要一个煎饼
        ABatterCake aBatterCake = new BatterCake();

        //加两个鸡蛋
        //装饰煎饼对象，并返回被装饰对象
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new EggDecorator(aBatterCake);

        //加一根香肠
        //装饰加鸡蛋的煎饼对象，并返回被装饰对象
        aBatterCake = new SausageDecorator(aBatterCake);

        /**
         *  通过debug可以发现:
         *      aBatterCake.getDesc() 和 aBatterCake.cost()都分别执行了一次SausageDecorator类的cost()方法和getDesc()方法，
         *      以及两次EggDecorator类的cost()方法和getDesc()方法，通过装饰器模式实现了加鸡蛋和加香肠的扩展，
         *      这时不管加几个鸡蛋、加几根香肠，只需在应用层调用对应的装饰类进行装饰即可，不用对底层的实现类进行二次扩展
         */
        System.out.println(aBatterCake.getDesc() + " 销售价格：" + aBatterCake.cost());


    }

}
