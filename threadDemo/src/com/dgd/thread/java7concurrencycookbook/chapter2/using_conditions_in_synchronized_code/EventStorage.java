package com.dgd.thread.java7concurrencycookbook.chapter2.using_conditions_in_synchronized_code;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        this.maxSize = 20;
        this.storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.printf("Thread : %s ,Set : %d\n", Thread.currentThread().getName(),storage.size());
        notifyAll();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Thread : %s,Get : %d : %s\n", Thread.currentThread().getName(), storage.size(), storage.poll());
        notifyAll();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
