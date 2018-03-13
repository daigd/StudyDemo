package com.dgd.adapter;

import java.util.List;

/**
 * @Author DGD
 * @date 2018/3/13.
 * 数据库操作日志接口
 */
public interface LogDBOperateApi {
    void createLog(LogModel logModel);

    List<LogModel> getAllLog();
}
