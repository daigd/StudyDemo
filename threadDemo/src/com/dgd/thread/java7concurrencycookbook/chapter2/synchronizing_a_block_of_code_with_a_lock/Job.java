package com.dgd.thread.java7concurrencycookbook.chapter2.synchronizing_a_block_of_code_with_a_lock;

/**
 * @Author DGD
 * @date 2018/3/15.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s : Going to print a document.\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s : The document has been printed.\n", Thread.currentThread().getName());
    }
}
