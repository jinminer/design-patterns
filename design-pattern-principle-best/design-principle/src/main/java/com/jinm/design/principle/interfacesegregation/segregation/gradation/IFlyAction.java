package com.jinm.design.principle.interfacesegregation.segregation.gradation;

/**
 * fly action interface
 * Created by jinm on  2019/07/08.
 */

public interface IFlyAction  extends IAnimalAction {

    /**
     *  飞翔类动物具备吃东西、飞翔行为
     */
    public void fly();
}
