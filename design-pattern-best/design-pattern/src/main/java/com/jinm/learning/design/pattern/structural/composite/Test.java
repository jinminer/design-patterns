package com.jinm.learning.design.pattern.structural.composite;

/**
 * test.
 * Created by jinm on  2019/08/09.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  组合模式：
         *      降低课程和课程所在目录的差异性，对客户端来说，课程目录和课程是同一体系，这也是组合模式的核心；
         *      主目录既可以添加子目录，也可以直接添加与子目录同级的课程
         */

        //一级目录：主目录
        CatalogComponent mainCatalog = new Catalog("课程主目录", 1);

        //一级课程：位于主目录下
        CatalogComponent linux = new Course("Linux课程", 99);
        CatalogComponent pythonCourse = new Course("Python课程", 88);

        //二级目录：位于主目录下
        CatalogComponent javaCatalog = new Catalog("Java课程目录", 2);

        //二级课程：位于子目录下
        CatalogComponent microservice = new Course("微服务课程", 998);
        CatalogComponent distribute = new Course("分布式课程", 888);

        //二级目录下，添加二级课程
        javaCatalog.add(microservice);
        javaCatalog.add(distribute);

        //主目录下，添加二级子目录
        mainCatalog.add(javaCatalog);

        //主目录下，添加一级课程
        mainCatalog.add(linux);
        mainCatalog.add(pythonCourse);

        mainCatalog.print();

    }

}
