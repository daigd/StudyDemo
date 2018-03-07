package com.dgd.thread.theartofconcurrentprogramming.chapter7_1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class AtomicReferenceArrayDemo {
    static AtomicReference<User> reference = new AtomicReference<>();
    public static void main(String[] args) {
        User user = new User("dai", 25);
        reference.set(user);
        User updateUser = new User("DDD", 27);
        reference.compareAndSet(user, updateUser);
        System.out.println(reference.get().getName());
        System.out.println(reference.get().getAge());
    }
}
