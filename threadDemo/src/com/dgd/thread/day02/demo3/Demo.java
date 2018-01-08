package com.dgd.thread.day02.demo3;

/**
 * @Author DGD
 * @date 2018/1/8.
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "A");
        Thread thread1 = new Thread(myThread, "B");
        Thread thread2 = new Thread(myThread, "C");
        Thread thread3 = new Thread(myThread, "D");
        Thread thread4 = new Thread(myThread, "E");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
