package com.jinm.abstractfactory.approache1;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        Computer pc = ComputerFactory.createComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        Computer server = ComputerFactory.createComputer(new ServerFacotry("2 GB","500 GB","2.4 GHz"));

        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);

    }

}
