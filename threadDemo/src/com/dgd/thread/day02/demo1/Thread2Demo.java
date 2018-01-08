package com.dgd.thread.day02.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DGD
 * @date 2018/1/8.
 */
public class Thread2Demo {
    public static void main(String[] args) {
        List<MyThread2> list = new ArrayList<>();
        for (int i=0;i<20;i++) {
            MyThread2 thread = new MyThread2(i);
            list.add(thread);
        }
        list.stream().forEach(thread0 -> thread0.start());
    }
}
