package com.dgd.adapter;

import java.util.List;

/**
 * @Author DGD
 * @date 2018/3/13.
 * 文件操作日志接口
 */
public interface LogFileOperateApi {

    List<LogModel> readLogFile();

    void writeLogFile(List<LogModel> logModels);
}
