package com.jinm.prototype.approach1;

import java.util.ArrayList;
import java.util.List;

public class ShallowEmployees implements Cloneable{

    private List<String> empList;

    public ShallowEmployees(){
        empList = new ArrayList<>();
    }

    public ShallowEmployees(List<String> list){
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

        return super.clone();
    }
}
