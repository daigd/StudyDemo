package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.util.concurrent.TimeUnit;

/**
 * @Author DGD
 * @date 2018/2/27.
 */
public class ThreadLocalDemo {

    //第一次调用get()会进行初始化，如果没有调用set()方法，每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        ThreadLocalDemo.begin();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Cost:" + ThreadLocalDemo.end());

        test(-12);
    }

    public static boolean test(int args) {
        assert args > 0 : "args cannot be less than 0";
        System.out.println("test()");
        return true;
    }
}
