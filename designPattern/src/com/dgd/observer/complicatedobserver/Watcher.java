package com.dgd.observer.complicatedobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 水质观察员
 */
public class Watcher implements WatcherObserver{
    //观察员的工作
    private String job;

    public String getJob() {
        return job;
    }

    @Override
    public void update(AbstractWaterQuality subject) {
        System.out.println(job+"获取到通知,当前水质情况为:"+subject.getPolluteLevel());
    }

    public void setJob(String job) {
        this.job = job;
    }

}
