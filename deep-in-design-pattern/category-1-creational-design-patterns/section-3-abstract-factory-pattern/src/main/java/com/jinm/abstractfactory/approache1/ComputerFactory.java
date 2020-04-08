package com.jinm.abstractfactory.approache1;

public class ComputerFactory {

    public static Computer createComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }

}
