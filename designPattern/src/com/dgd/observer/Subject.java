package com.dgd.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DaiGuodong
 * @create 2017-10-20-23:24
 * 观察者模式的目标对象
 */
public class Subject {
    //目标对象要维护观察者的信息
    private List<Observer> observers = new ArrayList<>();

    //添加观察者

    public void attach(Observer observer) {
        observers.add(observer);
    }

    //移除观察者

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    //给观察者发布通知
    public void noticeToAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
