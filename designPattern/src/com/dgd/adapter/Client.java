package com.dgd.adapter;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class Client {

    @Test
    public void logFileOperateTest() {
        LogModel logModel = new LogModel("1", "dgd", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "This is a test.");
        //List<LogModel> list = Arrays.asList(logModel);
        List<LogModel> list = new ArrayList<>();
        list.add(logModel);
        LogFileOperateApi api = new LogFileOperate();
        //写日志
        api.writeLogFile(list);
        //读取日志
        System.out.println(api.readLogFile());
    }

    @Test
    public void LogDBOperateTest() {
        LogModel logModel = new LogModel("2", "dgd", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Log DB");
        LogDBOperateApi api = new LogAdapter(new LogFileOperate());
        api.createLog(logModel);
        System.out.println(api.getAllLog());
    }
}
