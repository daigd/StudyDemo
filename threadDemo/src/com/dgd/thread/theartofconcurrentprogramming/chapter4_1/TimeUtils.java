package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author DGD
 * @date 2018/2/26.
 */
public class TimeUtils {
    public static String printTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
