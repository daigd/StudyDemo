package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.Random;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ThreadGroupExceptionTast implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / (int) (random.nextDouble() * 1000);
            System.out.printf("%s : %d\n", Thread.currentThread().getName(), result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("Thread %s : Interrupted.\n", Thread.currentThread().getName());
            }
        }
    }
}
