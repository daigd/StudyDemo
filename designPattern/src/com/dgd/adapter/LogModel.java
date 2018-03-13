package com.dgd.adapter;

import java.io.Serializable;

/**
 * @Author DGD
 * @date 2018/3/13.
 */
public class LogModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private String logId;
    private String operateUser;
    private String opeateTime;
    private String logContent;

    public LogModel(String logId, String operateUser, String opeateTime, String logContent) {
        this.logId = logId;
        this.operateUser = operateUser;
        this.opeateTime = opeateTime;
        this.logContent = logContent;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    public String getOpeateTime() {
        return opeateTime;
    }

    public void setOpeateTime(String opeateTime) {
        this.opeateTime = opeateTime;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "logId='" + logId + '\'' +
                ", operateUser='" + operateUser + '\'' +
                ", opeateTime='" + opeateTime + '\'' +
                ", logContent='" + logContent + '\'' +
                '}';
    }
}
