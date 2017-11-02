package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 *
 * wait()使调用该方法的线程释放共享资源的锁,进入等待状态,直到再次被唤醒
 */
public class WaitThread extends Thread {
    private Object lock;

    public WaitThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("开始,wait time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束,wait time = "+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
