package com.jinm.design.principle.singleresponsibility.methodlevelsingle;

/**
 * single responsibility method.
 * Created by jinm on  2019/07/05.  contact: keanemer.gmail.com
 */

public class Method {

    /**
     *  职责耦合模型
     *  更新用户姓名、更新地址、同时更新用户名和地址
     *  多种职责耦合在一起：
     *      如果要其中某一个参数的定义发生了变化，就要对整个方法进行修改，会对其他参数涉及到的业务造成影响
     *      比如：有一天，用户地址信息被单独存放到另一张地址信息表中，
     *                 这时候address字段存放的内容有原先String类型的具体地址，变成了Integer类型的地址表索引
     */
    public void updateUserInfo(String name, String address, String updateFlag){

        /**
         *  updateFlag：0-更新姓名；1-更新地址；其他-两者都更新
         */
        if ("0".equals(updateFlag)){
            name = "jinm";
            return;
        }else if ("1".equals(updateFlag)){
            address = "兰州";
            return;
        }else {
            name = "jinm";
            address = "兰州";
        }

    }

    /**
     *  单一职责模式
     *  隔离方法参数的职责，更新哪个字段，就调用哪个方法；
     *  如果某一个方法的定义变了，不会对其他方法的调用造成影响
     */
    public void updateUserName(String name){
        name = "jinm";
    }

    public void updateUserAddress(String address){
        address = "兰州";
    }

}
