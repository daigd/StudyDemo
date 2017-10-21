package com.dgd.observer.myobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 读者对象,实现了观察者接口
 */
public class Reader implements Observer {
    //读者的姓名
    private String name;
    @Override
    public void update(Subject subject) {
        System.out.println(name+"收到报纸了,阅读它,内容是:"+((Newspaper)subject).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
