package com.dgd.thread.theartofconcurrentprogramming.chapter7_1;

/**
 * @Author DGD
 * @date 2018/3/6.
 */
public class User {
    private String name;
    public volatile int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

