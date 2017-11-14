package com.dgd.observer.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 利用jdk自带的Observer接口
 * 实现具体的观察者对象
 */
public class Reader implements Observer {
    //读者的名字
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+"收到报纸了,报纸内容是:"+((Newspaper)o).getContent());
    }
}
