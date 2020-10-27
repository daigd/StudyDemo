package com.dgd.spring.beans.factory;

import org.springframework.context.ApplicationEvent;

/**
 * @author : DaiGD
 * @createtime :  2020年10月26日 16:50
 * @description :
 */
public class TestEvent extends ApplicationEvent
{
    private String msg;
    
    public TestEvent(Object source)
    {
        super(source);
    }

    public TestEvent(Object source, String msg)
    {
        super(source);
        this.msg = msg;
    }

    public void println()
    {
        System.out.println("This is a msg,content: " + msg);
    }
}
