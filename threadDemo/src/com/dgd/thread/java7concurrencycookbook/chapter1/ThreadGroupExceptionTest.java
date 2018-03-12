package com.dgd.thread.java7concurrencycookbook.chapter1;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class ThreadGroupExceptionTest {
    public static void main(String[] args) {
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        ThreadGroupExceptionTast tast = new ThreadGroupExceptionTast();

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(myThreadGroup, tast);
            thread.start();
        }
    }
}
