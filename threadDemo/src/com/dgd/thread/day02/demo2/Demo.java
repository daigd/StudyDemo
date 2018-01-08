package com.dgd.thread.day02.demo2;

/**
 * @Author DGD
 * @date 2018/1/8.
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("A");
        MyThread myThread1 = new MyThread("B");
        MyThread myThread2 = new MyThread("C");

        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
