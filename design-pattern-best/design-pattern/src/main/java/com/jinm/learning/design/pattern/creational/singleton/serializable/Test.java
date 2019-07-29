package com.jinm.learning.design.pattern.creational.singleton.serializable;

import java.io.*;

/**
 * test.
 * Created by jinm on  2019/07/30.  contact: keanemer.gmail.com
 */

public class Test {


    /**
     *  对象的序列化操作，会破坏单例，这里以懒汉模式举例
     *
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        HungrySingleton instance = HungrySingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton"));
        HungrySingleton instance1 = (HungrySingleton) ois.readObject();
        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);

    }

}
