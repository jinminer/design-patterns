package com.jinm.pattern.singleton.serializable;

import java.io.*;

/**
 *
 *  @author <a href="mailto:keanemer@gmail.com" > jinm </a>
 * Create by jinm on 2018/11/1 .
 */

public class SerializableTest {

    public static void main(String[] args) {

        SerializableSingleton s1 = SerializableSingleton.getInstance();
        SerializableSingleton s2 = null;

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("serializable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("serializable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SerializableSingleton) ois.readObject();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);


    }

}
