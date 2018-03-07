package com.dgd.thread.theartofconcurrentprogramming.chapter8_1;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class CountDownLatchTest {

    @Test
    public void test1() throws Exception{
        Thread parser1 = new Thread(()-> System.out.println("parser1 finish"));
        Thread parser2 = new Thread(()-> System.out.println("parser2 finish"));
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("All parser finish.");
    }


    @Test
    public void test2() throws Exception{
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(()->{
            System.out.println("1");
            latch.countDown();
        });
        Thread thread2 = new Thread(()->{
            System.out.println("2");
            latch.countDown();
        });

        thread1.start();
        thread2.start();

        latch.await();

        System.out.println("All finish.");

    }
}
