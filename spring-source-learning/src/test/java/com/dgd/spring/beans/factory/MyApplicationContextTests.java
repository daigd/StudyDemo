package com.dgd.spring.beans.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author : DaiGD
 * @createtime :  2020年10月22日 16:45
 * @description :
 */
public class MyApplicationContextTests
{
    @Test
    @DisplayName("容器实现-ApplicationContext-xml方式")
    void xmlApplicationContextTest()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MyApplicationContextTests.xml");
        MyTestBean bean = (MyTestBean) ctx.getBean("myTestBean");
        Assertions.assertEquals("myTest", bean.getName());
        System.out.println("myTest:" + bean.getName());
    }

    @Test
    @DisplayName("访问国际化信息")
    void messageSourceTest()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MyApplicationContextTests.xml");

        Object[] params = { "John", new GregorianCalendar().getTime() };
        String str1 = ctx.getMessage("msg", params, Locale.US);
        String str2 = ctx.getMessage("msg", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
        
        String str3 = ctx.getMessage("id", null, Locale.getDefault());
        System.out.println(str3);
    }

    @Test
    @DisplayName("事件监听测试")
    void eventListenerTest()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MyApplicationContextTests.xml");
        TestEvent event = new TestEvent(this, "Spring源码解析");
        ctx.publishEvent(event);
        
    }
}
