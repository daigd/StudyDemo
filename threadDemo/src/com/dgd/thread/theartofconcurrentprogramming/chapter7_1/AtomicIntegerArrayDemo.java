package com.dgd.thread.theartofconcurrentprogramming.chapter7_1;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class AtomicIntegerArrayDemo {
    static int[] array = new int[]{1, 2, 3};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 3);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(atomicIntegerArray.toString());
        System.out.println(array[0]);
    }

}
