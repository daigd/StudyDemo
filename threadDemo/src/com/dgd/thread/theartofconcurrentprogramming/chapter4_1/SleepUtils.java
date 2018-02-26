package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
