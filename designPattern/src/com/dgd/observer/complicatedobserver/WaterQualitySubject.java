package com.dgd.observer.complicatedobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 要观察的目标对象:即水质污染情况
 */
public class WaterQualitySubject extends AbstractWaterQuality{
    //水质情况:0-无污染,1-轻度污染,2-中度污染,3-高度污染
    private int polluteLevel;

    @Override
    public void notifyObservers() {
        for (WatcherObserver watcher : watcherList) {
            if (polluteLevel >= 1) {
                if ("监测人员".equals(watcher.getJob())) {
                    watcher.update(this);
                }
            }
            if (polluteLevel >= 2) {
                if ("预警人员".equals(watcher.getJob())) {
                    watcher.update(this);
                }
            }
            if (polluteLevel >= 3) {
                if ("监测部门人员".equals(watcher.getJob())) {
                    watcher.update(this);
                }
            }
        }
    }

    public int getPolluteLevel() {
        return polluteLevel;
    }

    public void setPolluteLevel(int polluteLevel) {
        //水质改变了
        this.polluteLevel = polluteLevel;
        //通知相应的观察员
        notifyObservers();

    }
}
