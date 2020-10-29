package com.dgd.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author : DaiGD
 * @createtime :  2020年10月29日 13:54
 * @description :
 */
@Aspect
public class AspectJTest
{
    @Pointcut("execution(* *.get*(..))")
    public void test()
    {
        
    }

    @Before("test()")
    public void beforeTest()
    {
        System.out.println("Before Test.");
    }

    @After("test()")
    public void afterTest()
    {
        System.out.println("After Test.");
    }
    
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p){
        System.out.println("Before around.");
        Object obj = null;
        try
        {
            obj = p.proceed();
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        System.out.println("After around.");
        return obj;
    }
}
