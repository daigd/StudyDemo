package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        WaitThread waitThread = new WaitThread(lock);
        waitThread.start();

        Thread.sleep(3000);

        NofityThread nofityThread = new NofityThread(lock);
        nofityThread.start();
    }
}
