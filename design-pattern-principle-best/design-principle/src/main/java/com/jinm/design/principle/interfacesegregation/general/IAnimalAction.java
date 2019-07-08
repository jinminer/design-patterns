package com.jinm.design.principle.interfacesegregation.general;

/**
 * animal action interface
 * Created by jinm on  2019/07/08.
 */

public interface IAnimalAction {

    /**
     *  IAnimalAction 接口兼备了：吃-eat()、飞-fly()、游泳-swim()三种行为特征
     *  如果有一种动物实现了这个接口，那么就必须实现这个接口的所有方法，
     *  这种实现是强制的，不管这种动物是否具备这种能力
     */

    public void eat();

    public void fly();

    public void swim();

}
