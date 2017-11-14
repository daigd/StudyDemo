package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 */
public class Thread01 extends Thread {
    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println("线程:"+Thread.currentThread().getName()+"在运行!");
        }
    }
}
