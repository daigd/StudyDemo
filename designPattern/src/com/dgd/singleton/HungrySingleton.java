package com.dgd.singleton;

/**
 * @Author DGD
 * @date 2018/3/21.
 * 饿汉式单例模式
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
