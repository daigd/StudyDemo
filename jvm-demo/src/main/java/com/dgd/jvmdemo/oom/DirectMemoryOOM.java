package com.dgd.jvmdemo.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : DaiGD
 * @createtime :  2021年01月06日 9:55
 * @description : 直接内存溢出演示：VM Args: -Xmx20m -XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOM
{
    private static final int _1M = 1024 *1024;
    
    private static int counter = 0;

    public static void main(String[] args) throws IllegalAccessException
    {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            try
            {
                counter++;
                unsafe.allocateMemory(_1M);  
            }catch (Throwable e){
                System.out.println("counter:" + counter);
                throw e;
            }
        }
    }
}
