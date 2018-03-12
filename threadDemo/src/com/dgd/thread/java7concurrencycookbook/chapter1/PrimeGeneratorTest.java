package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/10.
 */
public class PrimeGeneratorTest {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.interrupt();
    }
}
