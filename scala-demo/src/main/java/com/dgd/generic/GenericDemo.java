package com.dgd.generic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericDemo
{
    public static void main(String[] args)
    {
        System.out.println("Demo");
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();
        // 判断类型是否相等
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println("list1 className =" + list1.getClass().getSimpleName());
        System.out.println("list2 className =" + list2.getClass().getSimpleName());

        // 通过反射能将不同类型的数据放在同一个集合里
        EraseTest test = new EraseTest();
        test.test();
    }
}

class EraseTest{
    List<String> strList = new ArrayList<String>();
    List<Integer> intList = new ArrayList<Integer>();

    public void test()
    {
        Double d = 10D;
        strList.add("Java");
        intList.add(100);
        try
        {
            Field field1 = this.getClass().getDeclaredField("strList");
        
            field1.setAccessible(true);
            List strList2 = (List) field1.get(this);
            strList2.add(d);

            Field field2 = this.getClass().getDeclaredField("intList");
            field2.setAccessible(true);
            List intList2 = (List) field2.get(this);
            intList2.add(d);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("strList->" + strList);
        System.out.println("intList->" + intList);
    }
}

