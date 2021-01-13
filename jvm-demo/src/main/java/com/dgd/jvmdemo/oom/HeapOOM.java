package com.dgd.jvmdemo.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : DaiGD
 * @createtime :  2021年01月05日 10:33
 * @description : VM Args: -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError 
 * -XX:HeapDumpPath=gc.hprof -XX:+PrintGCDetails -Xloggc:gc.log
 */
public class HeapOOM
{
    static class OOMObject{}

    public static void main(String[] args)
    {
        List<OOMObject> list = new ArrayList<>();
        System.out.println("Demo");
        while (true){
            list.add(new OOMObject());
        }
    }
}
