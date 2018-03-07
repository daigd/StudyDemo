package com.dgd.thread.theartofconcurrentprogramming.chapter8_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author DGD
 * @date 2018/3/7.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore = new Semaphore(2);
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println("正在等待获得许可证的线程数:"+semaphore.getQueueLength());
                    System.out.println("是否有等待获得许可证的线程:"+semaphore.hasQueuedThreads());
                    System.out.println("save data...");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
