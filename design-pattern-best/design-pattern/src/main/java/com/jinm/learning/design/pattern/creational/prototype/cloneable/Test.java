package com.jinm.learning.design.pattern.creational.prototype.cloneable;

/**
 * test.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Mail mail = new Mail();
        mail.setContent("初始化模板......");
        System.out.println("调用构造函数创建mail:" + mail);
        for (int i = 0; i < 5; i++) {

            Mail tempMail = (Mail) mail.clone();
            tempMail.setName("姓名" + i);
            tempMail.setAddress("姓名" + i + "@gmail.com");
            tempMail.setContent("恭喜你, 离秃头又近了一步");
            MailUtil.sendMail(mail);
            System.out.println("调用克隆方法创建mail:" + tempMail);

        }

        MailUtil.saveOriginRecord(mail);

    }

}
