package com.jinm.pattern.singleton.test;

import com.jinm.pattern.singleton.hungry.Hungry;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by jinm on  2018/10/24.
 */

public class HungryThreadSafeTest {

    public static void main(String[] args) {

        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);


        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {

                    try {
                        latch.await();
                        Object object = Hungry.getInstance();
                        System.out.println(System.currentTimeMillis() + ":" + object);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();

            latch.countDown();
        }

    }

}
