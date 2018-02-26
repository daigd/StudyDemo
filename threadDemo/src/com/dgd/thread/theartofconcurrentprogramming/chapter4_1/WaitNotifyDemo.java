package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class WaitNotifyDemo {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) {
        new Thread(new Wait(), "WaitThread").start();
        SleepUtils.second(1);
        new Thread(new Notify(), "NotifyThread").start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true.wait at " + TimeUtils.printTime());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false.running at " + TimeUtils.printTime());

            }

        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                //获取lock的锁，然后进行通知，通知时不会释放锁
                System.out.println(Thread.currentThread() + " hold lock.notify at " + TimeUtils.printTime());
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized (lock) {
                //再次加锁
                System.out.println(Thread.currentThread() + " hold lock again.sleep at " + TimeUtils.printTime());
                SleepUtils.second(5);
            }
        }
    }


}
