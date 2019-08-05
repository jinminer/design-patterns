package com.jinm.learning.design.pattern.structural.adapter.classadapter;

/**
 * class adapter.
 * Created by jinm on  2019/08/05.  contact: keanemer.gmail.com
 */

public class Adaper extends Adaptee implements Target{

    /**
     *  类适配器：
     *      把Adaptee适配给Target
     *      建立被适配对象和适配后的目标之间的联系
     *      继承被适配对象，并实现目标类的接口规范，
     *      从而使得旧功能Adaper#adapteeRequest()，符合目标类Target#request()定义的规范，建立两者之间的联系
     */
    @Override
    public void request() {

        //......适配逻辑代码
        super.adapteeRequest();
        //......适配逻辑代码
    }

}
