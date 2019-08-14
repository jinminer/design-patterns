package com.jinm.learning.design.pattern.structural.proxy.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * dynamic data source.
 * Created by jinm on  2019/08/15.  contact: keanemer.gmail.com
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

     /**
      * Create by jinm on 2019/8/15 .
      * @description 获取当前线程对应的db事物上下文
      * @return java.lang.Object    当前线程对应的db对象
      */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDBType();
    }
}
