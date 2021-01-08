package com.dgd.jvmdemo.syntaxsugar;

import java.util.Arrays;
import java.util.List;

/**
 * @author : DaiGD
 * @createtime :  2021年01月07日 9:45
 * @description : for 循环语法糖
 */
public class ForSugar
{
    public static void main(String[] args)
    {
        String s = "TheApacheHadoop";
        for(char c : s.toCharArray())
        {
            System.out.printf("%s\t", c);
        }
        // 反编译结果:
        //   char[] var2 = s.toCharArray();
        //        int var3 = var2.length;
        //
        //        for(int var4 = 0; var4 < var3; ++var4) {
        //            char c = var2[var4];
        //            System.out.printf("%s\t", c);
        //        }
        System.out.println();

        List<String> list = Arrays.asList("Java", "Spring", "Hadoop", "Scala", "Spark");
        for(String s1 : list) {
            System.out.println(s1);
        }
        // 反编译结果:
        // Iterator var7 = list.iterator();
        //
        //        while(var7.hasNext()) {
        //            String s1 = (String)var7.next();
        //            System.out.println(s1);
        //        }
    }
}
