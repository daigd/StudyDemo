package com.dgd.jvmdemo.gc;

/**
 * @author : DaiGD
 * @createtime :  2021年01月08日 11:27
 * @description : 实战：内存分配与回收策略
 */
public class GCAction
{
    private static final int _1M = 1024 * 1024;
    
    public static void main(String[] args)
    {
        System.out.println("begin");
        //testAllocation();
//        testPretenureSizeThreshold();
        testTenuringThreshold();
        
    }

    /**
     * 验证对象优先有 Eden 分配
     * VM Args:
     * -XX:+UseSerialGC -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintHeapAtGC
     */
    private static void testAllocation()
    {
        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation4 = new byte[4 * _1M];
    }

    /**
     * 验证大对象直接进入老年代
     * VM Args: 
     * -XX:+UseSerialGC -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 
     * -XX:PretenureSizeThreshold 参数只对Serial和ParNew 两款新生代收集器有效，
     * 超过指定大小的对象直接进入老年代 （3145728为3M）
     * 如果必须使用此参数进行调优,可考虑ParNew加CMS的收集器组合
     */
    private static void testPretenureSizeThreshold()
    {
        byte[] allocation = new byte[3 * _1M];
    }

    /**
     * 验证存活多久对象将进入老年代
     * VM Args:
     * -XX:+UseSerialGC -Xmx20m -Xms20m -Xmn10m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -verbose:gc -XX:+PrintGCDetails 
     * MaxTenuringThreshold=1 : 表示对象一岁就进入老年代（在Survivor区每熬过一次GC，年龄就增加一岁）
     */
    private static void testTenuringThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1M / 4]; // 256 k
        System.out.println("allocation1");
        allocation2 = new byte[4 * _1M]; // 4096 k
        System.out.println("allocation2");
        allocation3 = new byte[4 * _1M]; // 4096 k
        System.out.println("allocation3 first");
        allocation3 = null;
        allocation3 = new byte[4 * _1M]; // 4096 k
        System.out.println("allocation3 second");
    }
    
}
