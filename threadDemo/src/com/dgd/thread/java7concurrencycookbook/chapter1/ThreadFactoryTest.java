package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ThreadFactoryTest {
    public static void main(String[] args) {
        MyThreadfactory threadfactory = new MyThreadfactory("MyThreadFactory");
        ThreadFactoryTask task = new ThreadFactoryTask();
        Thread thread;
        for (int i = 0; i < 10; i++) {
            thread = threadfactory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n",threadfactory.getStats());
    }
}
