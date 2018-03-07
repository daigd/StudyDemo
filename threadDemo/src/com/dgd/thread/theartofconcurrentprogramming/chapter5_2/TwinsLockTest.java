package com.dgd.thread.theartofconcurrentprogramming.chapter5_2;

import com.dgd.thread.theartofconcurrentprogramming.chapter4_1.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * @Author DGD
 * @date 2018/2/28.
 */
public class TwinsLockTest {

    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        /**
         * 工作线程:获取锁,并不释放锁，睡眠一秒，打印当前线程的名称，睡眠一秒，再释放锁
         */
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
