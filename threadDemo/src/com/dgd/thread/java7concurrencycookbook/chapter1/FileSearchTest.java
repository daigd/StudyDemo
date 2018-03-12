package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/3/10.
 */
public class FileSearchTest {
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("C:\\", "InstallConfig.ini");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
