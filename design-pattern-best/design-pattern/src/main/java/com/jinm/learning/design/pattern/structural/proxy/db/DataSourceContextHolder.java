package com.jinm.learning.design.pattern.structural.proxy.db;

/**
 * data source context holder.
 * Created by jinm on  2019/08/15.  contact: keanemer.gmail.com
 */

public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEST_HOLDER = new ThreadLocal<>();

    /**
     *  dbType  分库分表中的数据库，通过取模运算得到的路由id；
     *                对应spring容器配置中声明的 Bean ID
     */
    public static void setDBType(String dbType){
        CONTEST_HOLDER.set(dbType);
    }

    public static String getDBType(){
        return CONTEST_HOLDER.get();
    }

    public static void clearDBType(){
        CONTEST_HOLDER.remove();
    }

}
