package com.jinm.learning.design.pattern.structural.composite;

/**
 * catalog component
 * Created by jinm on  2019/08/08.
 */

public abstract class CatalogComponent {

    /**
     *  文件/目录抽象类
     *      使用组合模式定义文件/目录通用规则，在业务角度可以忽略组合对象和个别对象的差别
     *      通用规则方法默认抛出异常，有其子类去覆盖方法的实现，子类个性化实现，
     *      子类根据各自业务模型的不同，选择性的覆盖与自己业务模型相符合的方法，
     */

    public void add(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
