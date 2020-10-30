package com.dgd.spring.aop;

import com.dgd.spring.beans.factory.AsyncService;
import com.dgd.spring.beans.factory.MyTestBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author : DaiGD
 * @createtime :  2020年10月29日 13:46
 * @description :
 */
public class MyAopTests
{
    @Test
    @DisplayName("aop验证,对get方法进行了增强")
    void xmlApplicationContextTest()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MyAopTests.xml");
        MyTestBean bean = (MyTestBean) ctx.getBean("myTestBean");
        Assertions.assertEquals("myTest", bean.getName());
    }

    @Test
    @DisplayName("expose-proxy属性验证")
    void exposeProxyTest() throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("MyAopTests.xml");
        AsyncService service = (AsyncService) ctx.getBean("asyncServiceImpl");
        service.getName1();

        TimeUnit.SECONDS.sleep(1);
    }
}
