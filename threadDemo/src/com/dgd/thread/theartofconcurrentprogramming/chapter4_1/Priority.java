package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/2/26.
 * 线程优先级不能作为程序正确性的依赖，因为操作系统可能完全不理会Java线程对于优先级别的设定。
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;
    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }

        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        jobs.stream().forEach(item -> System.out.println("Job priority:" + item.priority + ",Job count:" + item.jobCount));

    }

    static class Job implements Runnable{
        private int priority;
        private int jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
