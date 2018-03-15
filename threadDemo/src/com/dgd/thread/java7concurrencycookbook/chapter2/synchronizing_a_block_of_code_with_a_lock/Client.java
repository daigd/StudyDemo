package com.dgd.thread.java7concurrencycookbook.chapter2.synchronizing_a_block_of_code_with_a_lock;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class Client {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread-" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
