package com.dgd.model;

/**
 * @author : DaiGD
 * @createtime :  2020年11月06日 11:15
 * @description :
 */
public class Demo
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override public String toString()
    {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }
}
