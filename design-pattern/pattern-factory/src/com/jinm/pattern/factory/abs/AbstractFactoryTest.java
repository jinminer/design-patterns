package com.jinm.pattern.factory.abs;

/**
 *  抽象工厂模式
 * Created by jinm on  2018/10/24.
 */

public class AbstractFactoryTest {

    public static void main(String[] args) {

        //对用户而言更加简单了
        //用户只有选择的权力了，保证了程序的健壮性

        MilkFactory milkFactory = new MilkFactory();
        System.out.println(milkFactory.getMengniu());

    }

}
