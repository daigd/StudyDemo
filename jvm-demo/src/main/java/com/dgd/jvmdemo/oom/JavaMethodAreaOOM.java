package com.dgd.jvmdemo.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @author : DaiGD
 * @createtime :  2021年01月05日 15:39
 * @description : 方法区内存溢出演示,使用CGlib创建大量代理类来填充方法区
 * JDK7 方法区还在永久代会出现内存溢出,
 * JDK8后 方法区放在元空间，很难产生内存溢出,验证一下是否是这样
 */
public class JavaMethodAreaOOM
{
    public static void main(String[] args)
    {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));

            enhancer.create();
        }
    }
    
    static class OOM{}
}
