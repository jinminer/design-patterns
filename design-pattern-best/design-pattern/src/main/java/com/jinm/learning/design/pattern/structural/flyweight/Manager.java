package com.jinm.learning.design.pattern.structural.flyweight;

/**
 * department manager.
 * Created by jinm on  2019/08/08.  contact: keanemer.gmail.com
 */

public class Manager implements Employee {

    /**
     *  部门管理者类
     *      部门管理者也是公司员工，所以实现员工接口，实现报告方法
     */

    //所在部门
    private String department;

    //报告内容
    private String reportContent;

    //Manager在new时肯定已经知道他是那个部门，所以提供一个带参的构造器
    public Manager(String department) {
        this.department = department;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }

    //为外部提供reportContent重置方法
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

}
