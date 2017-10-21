package com.dgd.observer;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 测试观察者模式
 */
public class ObserverClient {
    public static void main(String[] args) {
        //创建读者对象
        Reader reader = new Reader();
        reader.setName("张三");
        Reader reader1 = new Reader();
        reader1.setName("李四");
        Reader reader2 = new Reader();
        reader2.setName("王五");
        Newspaper newspaper = new Newspaper();

        //注册订阅者
        newspaper.attach(reader);
        newspaper.attach(reader1);
        newspaper.attach(reader2);

        //报纸出版了
        newspaper.setContent("本期内容:观察者模式");

        //王五退订了
        newspaper.detach(reader2);

        //报纸又出版了
        newspaper.setContent("本期内容:观察者模式详解");
    }
}
