package com.dgd.hbase.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * @author : DaiGD
 * @createtime :  2020年12月07日 17:07
 * @description :
 */
public class HBaseDemo
{
    private static Configuration config = null;

    private static HBaseAdmin admin = null;

    //zookeeper集群地址
    private final static String HB_ZK_QUORUM = "bigdata-01.com";

    //zk端口号
    private final static String HB_ZK_PORT = "2181";

    private static HTablePool tp = null;

    static
    {
        try
        {
            config = HBaseConfiguration.create();
            config.set("hbase.zookeeper.property.clientPort", HB_ZK_PORT);
            config.set("hbase.zookeeper.quorum", HB_ZK_QUORUM);
            admin = new HBaseAdmin(config);
            tp = new HTablePool(config, 10);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //获取表信息
    public static HTableInterface getTable(String tableName)
    {
        return tp.getTable(tableName);
    }

    public static void main(String args[])
    {
        //表名
        HTableInterface table = getTable("test");
        //　获取rowKey=001 的数据
        Get get = new Get(Bytes.toBytes("001"));
        try
        {
            Result result = table.get(get);
            System.out.println(result.size());
            byte[] age = result.getValue(Bytes.toBytes("info"), Bytes.toBytes("age"));
            System.out.println("age:" + Bytes.toString(age));
            System.out.println("result.value:" + Bytes.toString(result.value()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
