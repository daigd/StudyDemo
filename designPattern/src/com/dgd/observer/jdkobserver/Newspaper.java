package com.dgd.observer.jdkobserver;

import java.util.Observable;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 下面用java自带的类来实现具体的目标对象
 */
public class Newspaper extends Observable {
    //要出版的报纸内容
    private String content;

    public String getContent() {
        //获取报纸内容
        return content;
    }

    public void setContent(String content) {
        //要出版新一期的报纸了
        this.content = content;
        //明显表明状态发生了改变,通过源码可以知道,如果没有这行代码,不会执行notifyObservers()里面的逻辑
        this.setChanged();
        //通知订阅者
        notifyObservers();
    }
}
