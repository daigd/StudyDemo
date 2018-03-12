package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DataSourcesLoader(), "DataSourcesThread");
        Thread thread2 = new Thread(new NetworkConnectionsLoader(), "NetworkConnectionsThread");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main configuration has been finished : %s\n", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

    }
}
