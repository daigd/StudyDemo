package com.dgd.thread.theartofconcurrentprogramming.chapter6_1;

import com.dgd.thread.theartofconcurrentprogramming.chapter4_1.SleepUtils;

import java.util.HashMap;

/**
 * @Author DGD
 * @date 2018/3/2.
 */
public class HashMapDemo {
    public static final HashMap<String, String> map = new HashMap<>(2);
    public static void main(String[] args) throws InterruptedException {
        System.out.println(test());
    }

    public static boolean test(){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 25; i++) {
                map.put(String.valueOf(i), String.valueOf(i));
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 25; i < 50; i++) {
                map.put(String.valueOf(i), String.valueOf(i));
            }
        });

        t1.start();
        t2.start();

        SleepUtils.second(1);

        for (int i = 0; i < 50; i++) {
            //如果key和value不同，说明map在put的时候出现了异常
            if (!String.valueOf(i).equals(map.get(String.valueOf(i)))) {
                System.out.println(i + ":" + map.get(String.valueOf(i)));
                return true;
            }
        }
        return false;
    }
}
