package com.dgd.observer;

/**
 * @author DaiGuodong
 * @create 2017-10-20 23:24
 */
public interface Observer {
    //观察者改变状态的方法
    void update(Subject subject);
}
