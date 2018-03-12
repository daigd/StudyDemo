package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTask task = new ExceptionTask();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        try {
            thread.join();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finish.");
    }
}
