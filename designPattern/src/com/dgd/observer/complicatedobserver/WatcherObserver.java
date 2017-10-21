package com.dgd.observer.complicatedobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 水质观测员接口定义
 */
public interface WatcherObserver {

    //被通知的方法
    void update(AbstractWaterQuality subject);
    //设置观测人员的职位
    void setJob(String job);
    String getJob();
}
