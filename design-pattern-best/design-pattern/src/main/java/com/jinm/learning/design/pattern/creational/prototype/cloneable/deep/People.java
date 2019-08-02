package com.jinm.learning.design.pattern.creational.prototype.cloneable.deep;

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

        /**
         *  深克隆:
         *      单独对类的某个属性实现克隆方法
         */
        People p = (People) super.clone();
        p.birthday = (Date) p.birthday.clone();
        return p;

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
