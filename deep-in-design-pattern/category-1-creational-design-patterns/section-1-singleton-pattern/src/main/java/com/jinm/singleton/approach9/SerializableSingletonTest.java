package com.jinm.singleton.approach9;

import java.io.*;

public class SerializableSingletonTest {

    public static void main(String[] args) {

        SerializableSingleton instance1 = SerializableSingleton.getInstance();
        SerializableSingleton instance2 = null;

        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            instance2 = (SerializableSingleton) in.readObject();
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(instance1);
        System.out.println(instance2);

    }

}
