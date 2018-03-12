package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured.\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s : %s", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack trace:\n");
        e.printStackTrace(System.out);
        System.out.printf("Thread state : %s\n",t.getState());
    }
}
