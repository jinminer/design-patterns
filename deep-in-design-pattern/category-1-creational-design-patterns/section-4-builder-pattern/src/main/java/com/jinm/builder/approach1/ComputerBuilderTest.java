package com.jinm.builder.approach1;

public class ComputerBuilderTest {

    public static void main(String[] args) {

        Computer computer = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();

        System.out.println(computer);

    }

}
