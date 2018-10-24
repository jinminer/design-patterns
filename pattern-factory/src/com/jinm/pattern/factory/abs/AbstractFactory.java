package com.jinm.pattern.factory.abs;

import com.jinm.pattern.factory.Milk;

/**
 *  抽象工厂式用户的主入口
 *  在spring中应用最广泛的一种设计模式
 *  易于扩展
 *      比如新添加一个产品：三鹿
 *      简单工厂模式  需要用户知道三鹿这个配置，并进行修改
 *      工厂方法模式  需要用户重新new一个 SanluFactory
 *      抽象工厂模式  产品提供者在内部修改 接口之后，用户只需要进行调用相应的方法即可，不需要再继续额外的配置和new 操作
 *
 * Created by jinm on  2018/10/24.
 */

public abstract class AbstractFactory {


    //公共的逻辑
    //方便于统一管理
    /**
     *  可以添加流水线（组装）
     *  第一步：。。。
     *  第二部：。。。
     *  第三部：。。。
     *
     */


    /**
     *  获取一个蒙牛品牌的牛奶
     */
    public abstract Milk getTelunsu();

    /**
     *  获取一个蒙牛品牌的牛奶
     */
    public abstract Milk getMengniu();

    /**
     *  获取一个蒙牛品牌的牛奶
     */
    public abstract Milk getYili();

    /**
     *  获取一个蒙牛品牌的牛奶
     */
    public abstract Milk getSanlu();

}
