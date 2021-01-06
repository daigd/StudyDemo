package com.dgd.jvmdemo.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : DaiGD
 * @createtime :  2021年01月05日 13:51
 * @description : 运行时常量池溢出异常演示: VM Args:-Xmx6m -Xms6m
 */
public class RuntimeConstantPoolOOM
{
    public static void main(String[] args)
    {
        Set<String> set = new HashSet<>();
        int i = 0;
        while (true){
            try
            {
                set.add(String.valueOf(i++).intern());
            }catch (Throwable e){
                System.out.println("i = " + i);
                throw e;
            }
        }
    }
}
