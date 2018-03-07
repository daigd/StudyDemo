package com.dgd.thread.theartofconcurrentprogramming.chapter6_1;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author DGD
 * @date 2018/3/5.
 */
public class ConcurrentHashMapDemo {
    @Test
    public void test() {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap();
        map.put("a", "b");
        map.get("a");
    }
}
