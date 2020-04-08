package com.jinm.adapter;

import com.jinm.adapter.composition.SocketObjectAdapterImpl;
import com.jinm.adapter.inheritance.SocketClassAdapterImpl;

public class AdapterPatternTest {

    public static void main(String[] args) {

        classAdapterTest();
        System.out.println("-----------------------------------------");
        objectAdapterTest();

    }

    private static void classAdapterTest(){
        SocketAdapter adapter = new SocketClassAdapterImpl();
        Volt v120 = getVolt(adapter,120);
        Volt v12 = getVolt(adapter,12);
        Volt v3 = getVolt(adapter,3);

        System.out.println("v3 volts using Class Adapter="+v3.getVolts());
        System.out.println("v12 volts using Class Adapter="+v12.getVolts());
        System.out.println("v120 volts using Class Adapter="+v120.getVolts());
    }

    private static void objectAdapterTest(){
        SocketAdapter adapter = new SocketObjectAdapterImpl();
        Volt v120 = getVolt(adapter,120);
        Volt v12 = getVolt(adapter,12);
        Volt v3 = getVolt(adapter,3);

        System.out.println("v3 volts using Object Adapter="+v3.getVolts());
        System.out.println("v12 volts using Object Adapter="+v12.getVolts());
        System.out.println("v120 volts using Object Adapter="+v120.getVolts());
    }

    private static Volt getVolt(SocketAdapter adapter, int i){

        switch (i){
            case 120: return adapter.get120Volt();
            case 12: return adapter.get12Volt();
            case 3: return adapter.get3Volt();
            default: return adapter.get120Volt();

        }

    }

}
