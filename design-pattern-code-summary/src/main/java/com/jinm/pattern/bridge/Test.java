package com.jinm.pattern.bridge;

public class Test {

    public static void main(String[] args) {

        IMessage emailMessage = new EmailMessage();
        AbstractMessageAdapter adapter1 = new NormalMessage(emailMessage);
        adapter1.sendMessage("临时加班", "老王");

        IMessage smsMessage = new SmsMessage();
        AbstractMessageAdapter adapter2 = new UrgencyMessage(smsMessage);
        adapter2.sendMessage("线上问题修复", "客户");

    }

}
