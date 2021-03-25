package com.jinm.pattern.bridge;

public class UrgencyMessage extends AbstractMessageAdapter {

    public UrgencyMessage(IMessage message) {

        super(message);
    }

    @Override
    public void sendMessage(String message, String user) {
        message = "【八百里加急】" + message;
        super.sendMessage(message, user);
    }
}
