package com.dgd.singleton;

/**
 * @Author DGD
 * @date 2018/3/21.
 * 懒汉式单例实现一：双重检查
 */
public class DoubleCheckSingleton {
    private DoubleCheckSingleton(){}
    private volatile static DoubleCheckSingleton instance = null;

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
