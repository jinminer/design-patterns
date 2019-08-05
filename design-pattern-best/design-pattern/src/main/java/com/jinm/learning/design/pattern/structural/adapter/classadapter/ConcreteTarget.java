package com.jinm.learning.design.pattern.structural.adapter.classadapter;

/**
 * target instance.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class ConcreteTarget implements Target {

    /**
     *  预期符合适配规则的目标实例，
     *  可看作是被适配者的模板，被适配者经过适配器转换后，能够具备和目标实例相像的行为，
     *  这样就在不改变原有类的情况下，实现了新旧功能的无缝贴合，新系统可以提供适配器间接调用旧系统的功能
     */
    @Override
    public void request() {
        System.out.println("ConcreteTarget：具体的目标实例");
    }

}
