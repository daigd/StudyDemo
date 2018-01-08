package com.dgd.thread.day02.demo1;

/**
 * @Author DGD
 * @date 2018/1/8.
 */
public class MyThread2 extends Thread {
    private int i;

    public MyThread2(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Thread="+i+" is running.");
    }
}
