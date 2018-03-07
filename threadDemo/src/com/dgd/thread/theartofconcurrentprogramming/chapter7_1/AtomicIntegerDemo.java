package com.dgd.thread.theartofconcurrentprogramming.chapter7_1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class AtomicIntegerDemo {
    static AtomicInteger ai = new AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
