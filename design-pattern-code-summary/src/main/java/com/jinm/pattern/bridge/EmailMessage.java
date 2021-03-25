package com.jinm.pattern.bridge;

public class EmailMessage implements IMessage{
    @Override
    public void send(String message, String user) {
        System.out.println("使用 邮件 发送" + message + "给：" + user);
    }
}
