package com.dgd.observer.complicatedobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class Client {
    public static void main(String[] args) {
        Watcher watcher = new Watcher();
        watcher.setJob("监测人员");
        Watcher watcher1 = new Watcher();
        watcher1.setJob("预警人员");
        Watcher watcher2 = new Watcher();
        watcher2.setJob("监测部门人员");

        WaterQualitySubject waterQualitySubject = new WaterQualitySubject();
        //添加观测人员
        waterQualitySubject.attach(watcher);
        waterQualitySubject.attach(watcher1);
        waterQualitySubject.attach(watcher2);

        waterQualitySubject.setPolluteLevel(1);
        waterQualitySubject.setPolluteLevel(2);
        waterQualitySubject.setPolluteLevel(3);
    }
}
