package com.dgd.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
}
