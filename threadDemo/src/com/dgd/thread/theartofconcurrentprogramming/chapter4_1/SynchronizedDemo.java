package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {

        }
        m();
    }

    public static synchronized void m() {

    }
}
