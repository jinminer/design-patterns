package com.jinm.design.principle.interfacesegregation.segregation.divide;

/**
 * fly bird action implements.
 * Created by jinm on  2019/07/08.  contact: keanemer.gmail.com
 */

public class FlyBirdAction implements IAnimalAction, IFlyAction{

    /**
     *  同时具备飞翔能力和吃东西能力的鸟类，如燕子
     */
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }
}
