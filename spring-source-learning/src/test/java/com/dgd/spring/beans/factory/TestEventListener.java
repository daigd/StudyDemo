package com.dgd.spring.beans.factory;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author : DaiGD
 * @createtime :  2020年10月26日 16:52
 * @description :
 */
public class TestEventListener implements ApplicationListener
{
    @Override public void onApplicationEvent(ApplicationEvent event)
    {
        if(event instanceof TestEvent)
        {
            TestEvent te = (TestEvent) event;
            te.println();
        }
    }
}
