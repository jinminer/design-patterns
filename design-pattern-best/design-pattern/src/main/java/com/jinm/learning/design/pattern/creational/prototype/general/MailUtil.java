package com.jinm.learning.design.pattern.creational.prototype.general;

import java.text.MessageFormat;

/**
 * mail util.
 * Created by jinm on  2019/08/02.  contact: keanemer.gmail.com
 */

public class MailUtil {

    /**
     *  发送邮件
     */
    public static void sendMail(Mail mail){
        String outPutContent = "向{0}同事,邮件地址:{1},邮件内容{2},发送邮件成功!";
        System.out.println(MessageFormat.format(outPutContent, mail.getName(), mail.getAddress(), mail.getContent()));
    }

    /**
     *  存储原始邮件
     */
    public static void saveOriginRecord(Mail mail){
        System.out.println("存储OriginMail记录, OriginMail:" + mail.getContent());
    }

}
