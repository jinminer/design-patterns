package com.jinm.design.principle.interfacesegregation.segregation.divide;

/**
 * fly swim bird action implements.
 * Created by jinm on  2019/07/08.  contact: keanemer.gmail.com
 */

public class FlySwimBirdAction implements IAnimalAction, IFlyAction, ISwimAction{

    /**
     *  同时具备飞翔能力、游泳能力、东西能力的鸟类，如鸬鹚
     */
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
