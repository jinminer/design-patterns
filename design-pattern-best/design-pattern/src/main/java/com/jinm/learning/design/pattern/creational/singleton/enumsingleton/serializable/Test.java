package com.jinm.learning.design.pattern.creational.singleton.enumsingleton.serializable;

import java.io.*;

/**
 * test.
 * Created by jinm on  2019/07/31.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton-enum"));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton-enum"));
        EnumSingleton instance1 = (EnumSingleton) ois.readObject();

        System.out.println(instance.getData());
        System.out.println(instance1.getData());
        System.out.println(instance.getData() == instance1.getData());

    }

}
