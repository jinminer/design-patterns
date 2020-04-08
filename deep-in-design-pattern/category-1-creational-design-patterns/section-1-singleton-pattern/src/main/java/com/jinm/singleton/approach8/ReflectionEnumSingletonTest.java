package com.jinm.singleton.approach8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionEnumSingletonTest {

    public static void main(String[] args) {

        Resource resource1 = EnumSingleton.INSTANCE.getResource();
        Resource resource2 = null;

        try {

            for (Constructor<?> constructor : EnumSingleton.class.getDeclaredConstructors()){
                System.out.println(constructor);
            }

            Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
            //Below code will destroy the singleton pattern
            constructor.setAccessible(true);

            /**
             *
             * Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
             * 	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:484)
             * 	at com.jinm.singleton.approach8.ReflectionEnumSingletonTest.main(ReflectionEnumSingletonTest.java:31)
             */
            EnumSingleton enumSingleton = constructor.newInstance();
            resource2 = enumSingleton.getResource();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(resource1);
        System.out.println(resource2);

    }

}
