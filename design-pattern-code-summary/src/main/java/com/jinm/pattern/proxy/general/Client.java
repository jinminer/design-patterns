package com.jinm.pattern.proxy.general;

public class Client {

    public static void main(String[] args) {

        ISubject subject = new RealSubject();

        Proxy proxy = new Proxy(subject);

        proxy.request();

    }

}
