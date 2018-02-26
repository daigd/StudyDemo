package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

/**
 * @Author DGD
 * @date 2018/2/26.
 * Daemon线程的finally方法在JVM退出的时候不一定会执行
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonThread");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
