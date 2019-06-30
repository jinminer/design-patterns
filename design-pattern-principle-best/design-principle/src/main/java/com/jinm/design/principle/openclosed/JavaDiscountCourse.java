package com.jinm.design.principle.openclosed;

/**
 * java discount course.
 * Created by jinm on  2019/07/01.  contact: keanemer.gmail.com
 */

public class JavaDiscountCourse extends JavaCourse{

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    /**
     *  覆写父类方法
     *  扩展新特性：原价打8折
     */
    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }

    /**
     *  获取父类原有特性
     */
    public Double getOriginPrice(){
        return super.getPrice();
    }

}
