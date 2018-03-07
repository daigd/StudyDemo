package com.dgd.thread.theartofconcurrentprogramming.chapter7_1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class AtomicIntegerFieldUpdaterDemo {
    //创建原子更新器，设置要更新的类和属性
    //更新的字段必须（属性）必须使用public volatile来修饰
    static AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
    public static void main(String[] args) {
        User user = new User("conan", 10);
        System.out.println(updater.getAndIncrement(user));
        System.out.println(updater.get(user));
    }
}
