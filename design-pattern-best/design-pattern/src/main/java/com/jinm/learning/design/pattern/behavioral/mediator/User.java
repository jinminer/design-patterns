package com.jinm.learning.design.pattern.behavioral.mediator;

/**
 * .
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  用户发送消息的行为转交中介者StudyGroup去处理；
     *  即本来由用户直接发送给别人的消息，转化为，用户向中介者发消息，再由中介者发给其他人
     */
    public void sendMessage(String message){
        StudyGroup.showMessage(this, message);
    }

}
