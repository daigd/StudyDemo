package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class SafeTask implements Runnable {
    private static ThreadLocal<LocalDateTime> time = new ThreadLocal<LocalDateTime>(){
        @Override
        protected LocalDateTime initialValue() {
            return LocalDateTime.now();
        }
    };


    @Override
    public void run() {
        System.out.printf("Starting thread : %s : %s \n",Thread.currentThread().getId(),time.get().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Ending thread : %s : %s \n",Thread.currentThread().getId(),time.get().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
