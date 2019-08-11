package com.jinm.learning.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * catalog.
 * Created by jinm on  2019/08/09.  contact: keanemer.gmail.com
 */

public class Catalog extends CatalogComponent {

    private List<CatalogComponent> items = new ArrayList<>();
    private String name;

    /**
     *  类型控制标记：
     *      引入类型系统体系，对组合模式中的组合对象(节点)和个体对象(叶子节点)进行类型控制，用来处理其个性化需求，如不同级别的目录行缩进程度等;
     *      使用Integer类，而不是int类：int会有初始值，不便于进行判断处理
     */
    private Integer level;

    public Catalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void print() {
        //打印当前目录
        System.out.println(this.name);

        //打印子目录
        for (CatalogComponent catalogComponent : items){

            //类型控制，如果是目录对象实例则按照level控制级别进行行缩进
//            if (catalogComponent instanceof Catalog){
//                for (int i = 0; i < this.level; i++) {
//                    System.out.print("   ");
//                }
//            }

//            if (this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
//            }
            catalogComponent.print();
        }

    }
}
