package com.jinm.prototype.approach1;

import java.util.List;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);

        System.out.println("-------------------------------------------------------");

        ShallowEmployees emps1 = new ShallowEmployees();
        emps1.loadData();

        ShallowEmployees shallowEmps = (ShallowEmployees) emps1.clone();
        System.out.println("empsNew1 List: "+shallowEmps.getEmpList());

    }

}
