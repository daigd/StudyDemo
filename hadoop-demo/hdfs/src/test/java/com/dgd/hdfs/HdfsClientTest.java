package com.dgd.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClientTest {

    @Test
    @DisplayName("创建HDFS文件目录")
    void testMkdirs() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
//        conf.set("fs.defaultFS", "hdfs://hadoop104:9000");
//
//        FileSystem fs = FileSystem.get(conf);
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop104:9000"), conf, "hadoop");
        fs.mkdirs(new Path("/0221/banhua"));
        fs.close();
    }

    @Test
    @DisplayName("从本地拷贝文件到HDFS")
    void testCopyFromLocalFile() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "2");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop104:9000"), conf, "hadoop");
        fs.copyFromLocalFile(new Path("i:/banhua.txt"), new Path("/banhua-02.txt"));

        fs.close();
    }

    @Test
    @DisplayName("拷贝到文件到本地目录")
    void testCopyToLocalFile() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop104:9000"), conf, "hadoop");
        fs.copyToLocalFile(false, new Path("/banhua.txt"), new Path("i:/banhua-02.txt"), true);
        fs.close();
    }

    @Test
    @DisplayName("文件名更改")
    void testRename() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        //fs.copyFromLocalFile(new Path("e:/banzhang.txt"), new Path("/banzhang.txt"));
        fs.rename(new Path("/banzhang.txt"), new Path("/banzhang-2.txt"));
        
        fs.close();
    }

    @Test
    @DisplayName("获取文件信息")
    void testListFiles() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path("/"), true);

        while (iter.hasNext())
        {
            LocatedFileStatus status = iter.next();

            String name = status.getPath().getName();
            long fileLen = status.getLen();
            FsPermission permission = status.getPermission();
            String owner = status.getOwner();

            System.out.println("FileName:" + name);
            System.out.println("fileLen:" + fileLen);
            System.out.println("permission:" + permission);
            System.out.println("owner:" + owner);

            BlockLocation[] blockLocations = status.getBlockLocations();
            for(BlockLocation block : blockLocations) {
                for(String host : block.getHosts())
                {
                    System.out.println("Host:" + host);
                }
            }

            System.out.println("============分割线============");
        }
        
        fs.close();
    }

    @Test
    @DisplayName("文件或文件夹判断")
    void listFileOrDir() throws URISyntaxException, IOException, InterruptedException
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
        
        fs.close();
    }

    @Test
    @DisplayName("I/O流操作-文件上传")
    void putFile2HDFS() throws URISyntaxException, IOException, InterruptedException
    {
        // 1.获取文件系统
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        
        // 2.创建输入流
        InputStream fis = new FileInputStream(new File("e:/banhua.txt"));
        // 3.获取输出流
        FSDataOutputStream fos = fs.create(new Path("/banhua.txt"));
        // 4.流的对拷
        IOUtils.copyBytes(fis, fos, conf);
        // 5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    @DisplayName("I/O流操作-文件下载")
    void getFileFromHDFS() throws URISyntaxException, IOException, InterruptedException
    {
        // 1.获取文件系统
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        // 2.获取输入流
        FSDataInputStream fis = fs.open(new Path("/banhua.txt"));
        // 3.创建输出流
        OutputStream fos = new FileOutputStream(new File("e:/banhua2.txt"));
        // 4.流的对拷
        IOUtils.copyBytes(fis, fos, conf);
        // 5.关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    @DisplayName("下载大文件-1")
    void getBigFileFromHDFS() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        
        // 获取输入流
        FSDataInputStream fis = fs.open(new Path("/hadoop-2.7.2.tar.gz"));
        // 创建输出流
        OutputStream fos = new FileOutputStream(new File("e:/hadoop-2.7.2.tar.gz.part01"));
        // 流的对拷
        byte[] buf = new byte[1024];
        for(int i = 0; i < 1024 * 128; i++)
        {
            fis.read(buf);
            fos.write(buf);
        }
        // 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    @DisplayName("下载大文件2-定位文件读取")
    void getBigFileFromHDFS2() throws URISyntaxException, IOException, InterruptedException
    {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://bigdata101:9000"), conf, "bigdata");
        
        // 获取输入流
        FSDataInputStream fis = fs.open(new Path("/hadoop-2.7.2.tar.gz"));
        // 定位文件读取
        fis.seek(1024 * 1024 * 128);
        // 创建输出流
        OutputStream fos = new FileOutputStream(new File("e:/hadoop-2.7.2.tar.gz.part02"));
        // 流的对拷
        IOUtils.copyBytes(fis, fos, conf);
        // 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }
}
