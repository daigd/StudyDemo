package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread thread = new Thread(new SleepRunner(), "SleepThread");
        thread.setDaemon(true);

        Thread thread1 = new Thread(new BusyRunner(), "BusyThread");
        thread1.setDaemon(true);

        thread.start();
        thread1.start();

        //让SleepThread和BusyThread充分运行
        SleepUtils.second(5);

        thread.interrupt();
        thread1.interrupt();

        System.out.println("SleepThread interrupted is :"+thread.isInterrupted());
        System.out.println("BusyThread interrupted is :"+thread1.isInterrupted());

        //防止SleepThread和BusyThread立即退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
