package com.dgd.observer.complicatedobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 水质抽象类
 */
public abstract class AbstractWaterQuality {
    //维护水质观察员对象
    protected List<WatcherObserver> watcherList = new ArrayList<>();

    //添加
    public void attach(WatcherObserver observer) {
        watcherList.add(observer);
    }

    //删除
    public void detach(WatcherObserver observer) {
        watcherList.remove(observer);
    }
    //通知所有观察员
    public abstract void notifyObservers();

    //获取水质污染情况
    public abstract int getPolluteLevel();
}
