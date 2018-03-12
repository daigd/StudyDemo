package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        SearchTask searchTask = new SearchTask(new Result());

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of threads : %d\n", threadGroup.activeCount());
        System.out.printf("Information about the thread group :\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s : %s\n", threads[i].getName(), threads[i].getState());
        }

        waitFinish(threadGroup);

        threadGroup.interrupt();
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
