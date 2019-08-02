package com.jinm.learning.design.pattern.creational.prototype.cloneable;

/**
 * mail prototype cloneable.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class Mail implements Cloneable{

    private String name;
    private String address;
    private String content;

    public Mail(){
        System.out.println("mail class constructor");
    }

    /**
     *  实现Cloneable的clone()方法
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}' + super.toString();
    }
}
