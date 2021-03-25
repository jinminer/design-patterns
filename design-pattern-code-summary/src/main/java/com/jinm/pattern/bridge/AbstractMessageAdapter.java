package com.jinm.pattern.bridge;

public abstract class AbstractMessageAdapter{

    private IMessage message;

    public AbstractMessageAdapter(IMessage message){
        this.message = message;
    }

    public void sendMessage(String message, String user){
        this.message.send(message, user);
    }

}
