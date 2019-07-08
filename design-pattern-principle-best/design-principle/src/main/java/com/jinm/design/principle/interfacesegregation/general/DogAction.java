package com.jinm.design.principle.interfacesegregation.general;

/**
 * implements dog action.
 * Created by jinm on  2019/07/08.  contact: keanemer.gmail.com
 */

public class DogAction implements IAnimalAction {

    /**
     *  dog 不会飞但是却要实现 fly() 接口
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
