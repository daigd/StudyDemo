package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class SafeTaskTest {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
