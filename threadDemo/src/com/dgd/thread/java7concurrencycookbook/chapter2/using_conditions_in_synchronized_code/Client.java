package com.dgd.thread.java7concurrencycookbook.chapter2.using_conditions_in_synchronized_code;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class Client {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread thread = new Thread(producer,"Producer");
        Thread thread1 = new Thread(consumer,"Consumer");

        thread.start();
        thread1.start();

    }
}
