package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class DaemonTest {

    public static void main(String[] args) {
        Deque<Event> deque = new LinkedBlockingDeque<>();

        WriterTask writerTask = new WriterTask(deque);

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanTast cleanTast = new CleanTast(deque);
        cleanTast.start();
    }
}
