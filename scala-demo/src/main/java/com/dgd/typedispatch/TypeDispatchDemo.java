package com.dgd.typedispatch;

/**
 * @author : DaiGD
 * @createtime :  2020年12月28日 9:15
 * @description :
 */
public class TypeDispatchDemo
{
    public static void main(String[] args)
    {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHi(man);
        //当前方法=Human.sayHi()
        woman.sayHi(woman);
        //当前方法=Human.sayHi()
    }
}

abstract class Human
{
    void sayHi(Human human)
    {
        System.out.println("当前方法=Human.sayHi()");
    }
}

class Man extends Human
{
    void sayHi(Man human)
    {
        System.out.println("当前方法=Man.sayHi()");
    }
}

class Woman extends Human
{
    void sayHi(Woman woman)
    {
        System.out.println("当前方法=Woman.sayHi()");
    }
}
