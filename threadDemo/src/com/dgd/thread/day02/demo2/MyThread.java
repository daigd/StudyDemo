package com.dgd.thread.day02.demo2;

/**
 * @Author DGD
 * @date 2018/1/8.
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由线程:" + Thread.currentThread().getName() + "计算count,count=" + count);
        }
    }
}
