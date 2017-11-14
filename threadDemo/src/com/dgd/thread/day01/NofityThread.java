package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 *
 * nofity()唤醒队列中等待同一共享资源的一个线程,使其进入运行状态
 */
public class NofityThread extends Thread {
    private Object lock;

    public NofityThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始,notify = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束,notify = " + System.currentTimeMillis());
        }

    }
}
