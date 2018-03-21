package com.dgd.thread.java7concurrencycookbook.chapter2.using_conditions_in_synchronized_code;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class Consumer implements Runnable {
    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            eventStorage.get();
        }
    }
}