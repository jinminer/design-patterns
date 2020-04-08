package com.jinm.abstractfactory.approache1;

public class ServerFacotry implements ComputerAbstractFactory{

    private String ram;

    private String hdd;

    private String cpu;

    public ServerFacotry(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(this.ram, this.hdd, this.cpu);
    }
}
