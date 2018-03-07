package com.dgd.thread.theartofconcurrentprogramming.chapter8_2;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class BankWaterService implements Runnable {
    private CyclicBarrier c = new CyclicBarrier(4, this);
    //启动4个线程
    private ExecutorService e = Executors.newFixedThreadPool(4);
    //保存每个线程的计算结果
    private ConcurrentHashMap<String, Integer> result = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            e.execute(()->{
                //模拟计算
                result.put(Thread.currentThread().getName(), 1);
                //计算完成，插入一个屏障
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e1) {
                    e1.printStackTrace();
                }
            });
        }
        e.shutdown();
    }

    @Override
    public void run() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            sum += entry.getValue();
        }
        //将结果输出
        System.out.println(sum);
        result.put("result", sum);
    }

    public static void main(String[] args) {
        BankWaterService service = new BankWaterService();
        service.count();
    }
}
