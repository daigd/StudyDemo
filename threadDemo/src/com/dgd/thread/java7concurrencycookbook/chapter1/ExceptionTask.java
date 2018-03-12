package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ExceptionTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Integer.valueOf("TTT"));
    }
}
