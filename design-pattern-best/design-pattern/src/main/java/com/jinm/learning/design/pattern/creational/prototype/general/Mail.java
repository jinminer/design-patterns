package com.jinm.learning.design.pattern.creational.prototype.general;

/**
 * mail.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class Mail {

    private String name;
    private String address;
    private String content;

    public Mail(){
        System.out.println("mail class constructor");
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
}
