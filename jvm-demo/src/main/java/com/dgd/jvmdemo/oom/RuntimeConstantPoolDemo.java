package com.dgd.jvmdemo.oom;

/**
 * @author : DaiGD
 * @createtime :  2021年01月05日 14:48
 * @description :
 */
public class RuntimeConstantPoolDemo
{
    public static void main(String[] args)
    {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1);
        System.out.println(str1.intern() == str1);
        
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern() == str2);
        
    }
}
