package com.dgd.spring.beans.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author : DaiGD
 * @createtime :  2020年10月12日 17:21
 * @description :
 */
public final class MyBeanFactoryBeanTests
{
    @Test
    @DisplayName("容器实现-BeanFactory-xml方式")
    void xmlBeanFactoryTest()
    {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("MyBeanFactoryTests.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        Assertions.assertEquals("myTest", bean.getName());
        System.out.println("myTest:" + bean.getName());
    }
}
