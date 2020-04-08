package com.jinm.singleton.approach7;

import com.jinm.singleton.approach1.EagerInitializedSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {

    public static void main(String[] args){

        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instance2 = null;
        EagerInitializedSingleton instance3 = null;

        try {
            Constructor<EagerInitializedSingleton> constructor = EagerInitializedSingleton.class.getDeclaredConstructor();
            //Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();

            Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor1 : constructors){

                System.out.println(constructor1);

                //Below code will destroy the singleton pattern
                constructor1.setAccessible(true);
                instance3 = (EagerInitializedSingleton) constructor1.newInstance();
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);

    }

}
