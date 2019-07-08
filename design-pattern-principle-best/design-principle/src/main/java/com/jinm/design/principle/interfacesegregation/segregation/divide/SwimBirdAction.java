package com.jinm.design.principle.interfacesegregation.segregation.divide;

/**
 * swim bird action implements.
 * Created by jinm on  2019/07/08.  contact: keanemer.gmail.com
 */

public class SwimBirdAction implements IAnimalAction, ISwimAction{

    /**
     *  同时具备游泳能力和吃东西能力的鸟类，如企鹅
     */
    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }
}
