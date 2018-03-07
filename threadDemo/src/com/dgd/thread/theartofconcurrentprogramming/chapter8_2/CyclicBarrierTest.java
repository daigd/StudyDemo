package com.dgd.thread.theartofconcurrentprogramming.chapter8_2;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class CyclicBarrierTest {
    @Test
    public void test1() {
        CyclicBarrier c = new CyclicBarrier(2);
        test(c);
    }

    @Test
    public void test2() {
        CyclicBarrier c = new CyclicBarrier(2,()-> System.out.println("3"));
        test(c);
    }

    private void test(CyclicBarrier c) {
        Thread t = new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("1");
        });
        t.start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("2");
    }
}
