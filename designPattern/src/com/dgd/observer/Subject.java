package com.dgd.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DaiGuodong
 * @create 2017-10-20-23:24
 * 观察者模式的目标对象:
 * 它知道它的观察者,并提供添加观察者和删除观察者的接口
 */
public class Subject {
    //目标对象要维护观察者的信息
    private List<Observer> observers = new ArrayList<>();

    //添加观察者

    public void attach(Observer observer) {
        observers.add(observer);
    }

    //移除观察者

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //通知所有注册的观察者对象
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
