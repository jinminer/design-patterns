package com.jinm.learning.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * employee factory.
 * Created by jinm on  2019/08/08.  contact: keanemer.gmail.com
 */

public class EmployeeFactory {

    /**
     *  员工创建工厂类
     */

    //对象池：单例容器
    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<String, Employee>();

    public static Employee getManager(String department){

        //享元共享设计：如果没有创建并保存，如果有直接获取
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null){

            manager = new Manager(department);
            System.out.print("创建 " + department + " 负责人;" );
            String reportContent = department + "部门汇报：此次汇报的主要内容是......";
            manager.setReportContent(reportContent);
            System.out.println(" 创建报告 " + reportContent);
            EMPLOYEE_MAP.put(department, manager);


        }
        return manager;

    }

}
