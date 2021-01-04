package com.dgd.boxing;

/**
 * @author : DaiGD
 * @createtime :  2021年01月04日 10:18
 * @description : 自动装箱的陷阱
 */
public class BoxingDemo
{
    public static void main(String[] args)
    {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        // int 类型 -128 ~ 127 范围直接从内存中获取
        Integer h = 127;
        Integer i = 127;
        // 包装类使用"=="运算符，如果没有遇到算术运算不会拆箱
        // 包装类的 equals() 方法不处理数据转型的问题
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); // true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b)); // false
        System.out.println(h == i);
    }


}
