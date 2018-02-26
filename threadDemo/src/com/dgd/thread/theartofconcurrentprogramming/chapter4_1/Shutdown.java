package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runner(), "One");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        //通过interrupt()终结线程
        thread.interrupt();
        Runner two = new Runner();
        thread = new Thread(two, "Two");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        //通过标志位来控制线程的终结
        two.cancel();

    }

    static class Runner implements Runnable {
        private volatile boolean on = true;
        private long i;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("count i =" + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
