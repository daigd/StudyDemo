package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an exception.\n", t.getName());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the threads.\n");
        interrupt();
    }
}
