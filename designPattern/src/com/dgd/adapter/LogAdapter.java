package com.dgd.adapter;

import java.util.List;

/**
 * @Author DGD
 * @date 2018/3/13.
 * 使用适配器模式：LogDBOperateApi是目标(Target)接口,LogFileOperateApi是适配器对象
 */
public class LogAdapter implements LogDBOperateApi {
    private LogFileOperateApi api;

    public LogAdapter(LogFileOperateApi api) {
        this.api = api;
    }

    @Override
    public void createLog(LogModel logModel) {
        //先读取文件的内容
        List<LogModel> list = api.readLogFile();
        if (list != null) {
            list.add(logModel);
            //重新写入
            api.writeLogFile(list);
        }
    }

    @Override
    public List<LogModel> getAllLog() {
        return api.readLogFile();
    }
}
