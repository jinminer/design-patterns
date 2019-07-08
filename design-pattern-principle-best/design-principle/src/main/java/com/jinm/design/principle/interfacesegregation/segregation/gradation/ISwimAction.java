package com.jinm.design.principle.interfacesegregation.segregation.gradation;

/**
 * swim action interface.
 * Created by jinm on  2019/07/08.  contact: keanemer.gmail.com
 */

public interface ISwimAction extends IAnimalAction {

    /**
     *  游泳动物具备吃东西、游泳行为
     */
    public void swim();

}
