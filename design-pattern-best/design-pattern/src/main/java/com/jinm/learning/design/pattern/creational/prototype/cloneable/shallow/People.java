package com.jinm.learning.design.pattern.creational.prototype.cloneable.shallow;

import java.util.Date;

/**
 * people.
 * Created by jinm on  2019/08/03.  contact: keanemer.gmail.com
 */

public class People implements Cloneable{

    private String name;
    private Date birthday;

    public People(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}' + super.toString();
    }
}
