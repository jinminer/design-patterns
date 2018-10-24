package com.jinm.pattern.factory.function;

import com.jinm.pattern.factory.Milk;

/**
 *  工厂模型
 *
 * Created by jinm on  2018/10/23.
 */

public interface Factory {

    //工厂必然具有生产产品的技能，统一的产品出口
    Milk getMilk();

}
