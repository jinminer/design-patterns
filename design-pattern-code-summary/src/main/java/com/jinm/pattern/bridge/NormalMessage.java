package com.jinm.pattern.bridge;


public class NormalMessage extends AbstractMessageAdapter {

    public NormalMessage(IMessage message) {
        super(message);
    }

}
