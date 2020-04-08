package com.jinm.prototype.approach1;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<>();
    }

    public Employees(List<String> list){
        this.empList=list;
    }
    public void loadData(){
        //read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < empList.size(); i ++){
            temp.add(empList.get(i));
        }

        return new Employees(temp);
    }
}
