package com.dgd.observer.myobserver;

/**
 * @author DaiGuodong
 * @create 2017-10-20 23:24
 */
public interface Observer {
    /**
     * 观察者改变状态的方法
     * @param subject 传入目标对象,方便获取目标对象的状态
     */
    void update(Subject subject);
}
