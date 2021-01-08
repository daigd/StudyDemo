package com.dgd.jvmdemo.gc;

/**
 * @author : DaiGD
 * @createtime :  2021年01月06日 10:28
 * @description : 验证HotSpot 垃圾回收算法是否是引用计数器法
 * VM Args: -Xmx100m -Xms100m -XX:+PrintGCDetails
 */
public class ReferenceCountingGC
{
    private static final int _1M =  1024 *1024;
    
    public Object instance = null;

    private byte[] bigSize = new byte[10 * _1M];

    public static void main(String[] args)
    {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        
        objA = null;
        objB = null;
        
        System.gc();
    }
}
