package com.jinm.learning.design.pattern.creational.prototype.general;

/**
 * test.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Mail originMail = new Mail();
        originMail.setContent("初始化模板......");

        /**
         *  模拟发送邮件：
         *      每发送一次邮件就创建一个Mail对象实例，会产生大量的对象
         *      如果Mail对象内部构造较为复杂，就会严重消耗内存资源
         */
        for (int i = 0; i < 5; i++) {
            //发送邮件
            Mail sendMail = new Mail();
            sendMail.setName("姓名" + i);
            sendMail.setAddress("姓名" + i + "@gmail.com");
            sendMail.setContent("恭喜你, 离秃头又近了一步");
            MailUtil.sendMail(sendMail);
        }

        /**
         *  保存原始邮件信息：邮件的发送结果信息等
         */
        MailUtil.saveOriginRecord(originMail);

    }

}
