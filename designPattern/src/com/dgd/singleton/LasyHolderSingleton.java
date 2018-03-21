package com.dgd.singleton;

/**
 * @Author DGD
 * @date 2018/3/21.
 */
public class LasyHolderSingleton {
    private LasyHolderSingleton() {}

    private static class Holder{
        private static LasyHolderSingleton instance = new LasyHolderSingleton();
    }

    public static LasyHolderSingleton getInstance() {
        return Holder.instance;
    }
}
