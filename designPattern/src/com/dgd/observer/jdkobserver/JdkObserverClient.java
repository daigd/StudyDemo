package com.dgd.observer.jdkobserver;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class JdkObserverClient {
    public static void main(String[] args) {
        //创建读者对象
        Reader reader = new Reader();
        reader.setName("张三");

        Reader reader1 = new Reader();
        reader1.setName("李四");

        Reader reader2 = new Reader();
        reader2.setName("王五");

        //创建报纸对象
        Newspaper newspaper = new Newspaper();
        //先添加观察者
        newspaper.addObserver(reader);
        newspaper.addObserver(reader1);
        newspaper.addObserver(reader2);

        //报纸出版了
        newspaper.setContent("本期内容是:利用JDK自带的类来实现观察者模式");

        //王五退订了报纸
        newspaper.deleteObserver(reader2);

        //报纸又出版了
        newspaper.setContent("本期内容是:学会了观察者模式");
    }
}
