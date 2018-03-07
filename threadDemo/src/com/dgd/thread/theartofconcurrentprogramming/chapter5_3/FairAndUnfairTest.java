package com.dgd.thread.theartofconcurrentprogramming.chapter5_3;

import com.dgd.thread.theartofconcurrentprogramming.chapter4_1.SleepUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author DGD
 * @date 2018/2/28.
 */
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unFairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
        //testLock(fairLock);
        testLock(unFairLock);

    }



    //启动5个线程
    private static void testLock(Lock lock) {
        for (int i = 0; i < 100; i++) {
            Job job = new Job(lock);
            job.setName(String.valueOf(i));
            job.start();
        }

    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                SleepUtils.second(1);
                System.out.println("Lock by [" + Thread.currentThread().getName() + "],Waiting by " + ((ReentrantLock2)lock).getQueuedThreads());
            }finally {
                lock.unlock();
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(list);
            return list;
        }
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("2", "3", "4", "5", "6");
        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+",>>1="+(i>>1));
        }
    }

    @Test
    public void test4() {
        int a = (1 << 16) - 1;

        System.out.println(a+","+Integer.toHexString(a));
        System.out.println((1 & a) + "," + Integer.toHexString((1 & a)));
        System.out.println(Integer.toHexString(2>>>16));
        int b = 1<<16;
        System.out.println(b+","+Integer.toHexString(b));
    }

}
