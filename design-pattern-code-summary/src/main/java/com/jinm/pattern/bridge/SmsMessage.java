package com.jinm.pattern.bridge;

public class SmsMessage implements IMessage{
    @Override
    public void send(String message, String user) {
        System.out.println("使用 短信 发送" + message + "给：" + user);
    }
}
