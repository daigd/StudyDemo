package com.dgd.thread.day01;

/**
 * @Author DGD
 * @date 2017/11/2.
 */
public class DaemonThread extends Thread{
    private int i;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
