package com.dgd.thread.theartofconcurrentprogramming.chapter5_4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author DGD
 * @date 2018/3/1.
 * 读写锁示例:通过读写锁来保证HashMap在多线程环境下是线程安全的
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock r = readWriteLock.readLock();
    static Lock w = readWriteLock.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }

    }

    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        }finally {
            w.unlock();
        }
    }

    static class Job extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

}
