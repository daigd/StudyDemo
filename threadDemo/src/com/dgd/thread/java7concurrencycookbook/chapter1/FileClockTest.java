package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class FileClockTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new FileClock());

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

    }
}
