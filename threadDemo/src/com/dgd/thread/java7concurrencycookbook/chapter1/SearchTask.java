package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class SearchTask implements Runnable {

    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread name : %s\n", name);
        try {
            doTast();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread : %s Interrupted.\n", name);
            return;
        }
        System.out.printf("Thread : %s End\n",name);
    }

    private void doTast() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s : %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }
}
