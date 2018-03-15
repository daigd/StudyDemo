package com.dgd.thread.java7concurrencycookbook.chapter2.synchronizing_a_block_of_code_with_a_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf(Thread.currentThread().getName() + ": PrintQueue : Printing a job during " + (duration / 1000) + "seconds.\n");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }
}
