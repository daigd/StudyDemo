package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Hello Thread!");

        //创建线程的第一种方式：继承Thread类,重写run()方法
        Thread thread = new Thread01();

        thread.start();

        for (int i=0;i<5;i++) {
            System.out.println("main线程:"+Thread.currentThread().getName()+"在运行!");
        }

        //第二种方式:实现Runnable接口
        new Thread(() -> System.out.println("第二种创建线程的方式:"+Thread.currentThread().getName()+"在运行!")).start();

    }


}
