package com.dgd.hdfs.day02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author : DaiGD
 * @createtime :  2021年02月25日 9:28
 * @description :
 */
public class HDFSTest
{
    @Test
    @DisplayName("测试文件上传,使用代码设置参数")
    void testFilePut1() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "2");
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        fs.copyFromLocalFile(new Path("e:/banzhang.txt"), new Path("/banzhang-0225-02.txt"));
    
        fs.close();
    }

    @Test
    @DisplayName("文件上传,使用配置文件参数")
    void testFilePut2() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        fs.copyFromLocalFile(new Path("e:/banzhang.txt"), new Path("/banzhang-0225-03.txt"));
        fs.close();
    }

    @Test
    @DisplayName("测试文件下载")
    void testGetFile() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        fs.copyToLocalFile(new Path("/input/wc.txt"), new Path("e:/0225-wc.txt"));
        
        fs.close();
    }

    @Test
    @DisplayName("目录的创建")
    void testMkdir() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        fs.mkdirs(new Path("/0225/input"));
        
        fs.close();
    }

    @Test
    @DisplayName("文件夹更名")
    void testRenameDir() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        fs.rename(new Path("/0225/input"), new Path("/0225/input-01"));

        fs.close();
    }

    @Test
    @DisplayName("目录删除")
    void testRmDir() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        fs.delete(new Path("/0225"), true);
        
        fs.close();
    }

    @Test
    @DisplayName("文件详情查看")
    void testListFile() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path("/"), true);
        while (iter.hasNext()) {
            LocatedFileStatus status = iter.next();
            System.out.println("File Name:" + status.getPath().getName());
            System.out.println("File Len:" + status.getLen());
            System.out.println("File Group:" + status.getGroup());

            BlockLocation[] locations = status.getBlockLocations();
            for(BlockLocation location : locations)
            {
                String[] hosts = location.getHosts();
                for(String host : hosts)
                {
                    System.out.println("File Location Host:" + host);
                }
            }
            System.out.println("==============分割线==============");
        }
    }

    @Test
    @DisplayName("文件和文件夹的判断")
    void testFileOrDir() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        FileStatus[] status = fs.listStatus(new Path("/"));
        for(FileStatus fileStatus : status)
        {
            if(fileStatus.isFile()) {
                System.out.println("File:" + fileStatus.getPath().getName());
            }else{
                System.out.println("Dir:" + fileStatus.getPath().getName());
            }
        }
    }

    @Test
    @DisplayName("IO流操作-文件上传")
    void testPutFileByIO() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        InputStream fis = new FileInputStream(new File("e:/banhua.txt"));
        FSDataOutputStream fos = fs.create(new Path("/0225/input/banhua.txt"), true);
        IOUtils.copyBytes(fis, fos, conf, false);

        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    @DisplayName("IO流操作-文件下载")
    void testGetFileByIO() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        
        // 1.获取输入流
        FSDataInputStream fis = fs.open(new Path("/0225/input/banhua.txt"));
        // 2.创建输出流
        OutputStream fos = new FileOutputStream(new File("e:/banhua-0225.txt"));
        // 3.流的对拷
        IOUtils.copyBytes(fis, fos, conf, false);
        
        // 4.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    @DisplayName("定位文件读取01")
    void testGetFile2ByIO() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");

        // 创建IO流
        FSDataInputStream fis = fs.open(new Path("/hadoop-2.7.2.tar.gz"));
        OutputStream fos = new FileOutputStream(new File("e:/hadoop-2.7.2.tar.gz-part01"));

        // 流的对拷
        byte[] buf = new byte[1024];
        for(int i = 0; i < 1024 * 128; i++)
        {
            fis.read(buf);
            fos.write(buf);
        }

        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    @DisplayName("定位文件读取02")
    void testGetFile3ByIO() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        
        // 创建IO流
        FSDataInputStream fis = fs.open(new Path("/hadoop-2.7.2.tar.gz"));
        OutputStream fos = new FileOutputStream(new File("e:/hadoop-2.7.2.tar.gz-part02"));
        
        // 流的对拷
        // 定位从哪里开始读取
        fis.seek(1024 * 1024 * 128);
        IOUtils.copyBytes(fis, fos, conf, false);
        
        // 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }
}
