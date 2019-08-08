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
            if (this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
            }
            catalogComponent.print();
        }

    }
}
