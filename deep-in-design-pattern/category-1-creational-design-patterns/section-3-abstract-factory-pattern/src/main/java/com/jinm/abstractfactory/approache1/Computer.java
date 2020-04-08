package com.jinm.abstractfactory.approache1;

public abstract class Computer {

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "Computer{ RAM = "+getRAM()+", HDD = "+getHDD()+", CPU = "+getCPU()+"}";
    }
}
