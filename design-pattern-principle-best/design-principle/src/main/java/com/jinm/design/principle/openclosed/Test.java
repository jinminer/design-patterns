package com.jinm.design.principle.openclosed;

/**
 * test.
 * Created by jinm on  2019/06/18.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        //ICourse course = new JavaCourse(99, "数据结构", 998d);
        /**
         * 新需求：课程需要打折
         *      普通修改方法：直接修改 JavaCourse 类和ICourse接口，增加一个折扣计算方法
         *                    缺点：1.底层接口应该是稳定的，对修改关闭、对扩展开放；
         *                              2.直接修改底层接口会对原始业务造成影响，需要逐个修改该接口的调用模块；
         *                              3.如果新增特性较多，并且有多个服务模块调用该接口，修改内容过多，不易于维护；
         *      遵循开闭原则修改：在原有类 JavaCourse 派生出 JavaDiscountCourse 折扣子类
         *                    优点：1.遵循开闭原则：对于基层接口修改关闭，对扩展开放；
         *                              2.不会对原有业务造成影响；
         *                              3.如果是新增多个特性，代码修改范围也较小，可扩展性、可维护性较高
         *
         */
        ICourse course = new JavaDiscountCourse(99, "数据结构", 998d);

        /**
         *  对象下转：获取派生类新特性
         */
        JavaDiscountCourse discountCourse = (JavaDiscountCourse) course;
        System.out.println(" 课程ID:" + course.getId() + " 课程名称:" + course.getName() + " 课程原价:" + discountCourse.getOriginPrice() + "元" + " 课程折扣价:" + course.getPrice() + "元");

    }

}
