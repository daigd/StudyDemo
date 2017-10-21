package com.dgd.observer.myobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 下面通过报社和读者来描述观察者模式的实现
 * 报社发行报纸,每一期报纸出版了通知读者
 */
public class Newspaper extends Subject{
    //每一期的报纸
    private String content;
    //获取报纸的具体内容
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        //报纸出版了
        this.content = content;
        //通知所有订阅了报纸的读者
        notifyObservers();
    }
}
