package com.dgd.thread.theartofconcurrentprogramming.chapter4_1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author DGD
 * @date 2018/2/26.
 * java程序天生是多线程程序
 * [1]main  main线程，用户程序入口
   [2]Reference Handler  清除Reference的线程
   [3]Finalizer  调用对象finalize方法的线程
   [4]Signal Dispatcher  分发处理发送给JVM信号的线程
   [5]Attach Listener
   [10]Monitor Ctrl-Break
 *
 */
public class MultiThread {
    public static void main(String[] args) {
        //获取线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer信息,仅获取线程和线程堆栈的信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Arrays.stream(threadInfos).sorted(Comparator.comparing(ThreadInfo::getThreadId)).forEach(item -> System.out.println("[" + item.getThreadId() + "]" + item.getThreadName()));
    }
}
