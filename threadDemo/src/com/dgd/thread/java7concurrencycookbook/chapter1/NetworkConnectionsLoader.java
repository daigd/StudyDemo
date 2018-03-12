package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connection loading :　%s\n", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network connection has finished : %s\n", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
