package com.dgd.spring.beans.factory;

import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;

/**
 * @author : DaiGD
 * @createtime :  2020年10月30日 14:46
 * @description :
 */
public class AsyncServiceImpl implements AsyncService
{
    public void getName1()
    {
        System.out.println("getName1");
        // this 调用导致切面 不生效
        // AOP 配置里设置 expose-proxy="true"，调用方式改成：((AsyncService)AopContext.currentProxy()).test2();
        //this.getName2();
        ((AsyncService)AopContext.currentProxy()).getName2();
    }

    public void getName2()
    {
        System.out.println("getName2");
    }
}
