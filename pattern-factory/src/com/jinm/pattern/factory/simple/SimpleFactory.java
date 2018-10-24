package com.jinm.pattern.factory.simple;

import com.jinm.pattern.factory.Mengniu;
import com.jinm.pattern.factory.Milk;
import com.jinm.pattern.factory.Telunsu;
import com.jinm.pattern.factory.Yili;

/**
 * Created by jinm on  2018/10/23.
 */

public class SimpleFactory {

    public Milk getMilk(String name){

        if ("蒙牛".equals(name)) {
            return new Mengniu();
        }else if ("特仑苏".equals(name)) {
            return new Telunsu();
        }else if ("伊利".equals(name)) {
            return new Yili();
        }else {
            System.out.println("不能生产您所需要的产品");
            return null;
        }
    }

}
