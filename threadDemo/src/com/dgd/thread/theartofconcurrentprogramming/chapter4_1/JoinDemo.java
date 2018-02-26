package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class JoinDemo {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), "Thread" + i);
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getName()+" terminate.");
        }
    }
}
