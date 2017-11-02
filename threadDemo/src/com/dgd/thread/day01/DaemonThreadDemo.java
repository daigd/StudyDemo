package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 * 守护线程示例
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        //设置成守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            //模拟main线程等待5秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒过后,我要退出了,I am "+Thread.currentThread().getName());
        //main线程停止运行后,daemon线程也会自动停止运行
    }

}
