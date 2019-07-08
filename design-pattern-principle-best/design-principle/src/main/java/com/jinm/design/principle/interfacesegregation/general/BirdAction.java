package com.jinm.design.principle.interfacesegregation.general;

/**
 * implements bird action.
 * Created by jinm on  2019/07/08.  contact: keanemer.gmail.com
 */

public class BirdAction implements IAnimalAction {

    /**
     *  有些鸟类不能飞翔，但是却要实现 fly() 接口，比如：企鹅、鸵鸟
     *  有些鸟类不具备游泳能力，但却要实现swim()接口
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
