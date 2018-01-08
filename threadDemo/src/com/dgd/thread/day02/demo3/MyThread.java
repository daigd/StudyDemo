package com.dgd.thread.day02.demo3;

/**
 * @Author DGD
 * @date 2018/1/8.
 */
public class MyThread extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        //super.run();
        count--;
        System.out.println("由线程："+Thread.currentThread().getName()+"计算,count="+count);
    }
}
