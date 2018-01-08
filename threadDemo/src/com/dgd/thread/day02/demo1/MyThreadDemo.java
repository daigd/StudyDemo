package com.dgd.thread.day02.demo1;

/**
 * @Author DGD
 * @date 2018/1/8.
 * 线程的随机性
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("MyThread");
        myThread.start();

        for (int i=0;i<10;i++) {
            int time = (int) (Math.random()*1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main="+Thread.currentThread().getName()+",sleepTime="+time);
        }
    }
}
