package com.dgd.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author DaiGuodong
 * @date 2017/10/16.
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler {
    private Order order;

    public OrderApi getProxyInterface(Order order) {
        //设置被代理的对象,好方便invoke里面的操作
        this.order = order;
        //把真正的对象和代理对象关联起来
        OrderApi orderApi = (OrderApi) Proxy.newProxyInstance(order.getClass().getClassLoader(), order.getClass().getInterfaces(), this);
        return orderApi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果调用set方法就要检查权限,如果不是创建人不允许修改
        if (method.getName().startsWith("set")) {
            if (order.getOrderUser() != null && !order.getOrderUser().equals(args[1])) {
                System.out.println("对不起,"+args[1]+"您无权修改数据");
            }else{
                return method.invoke(order, args);
            }
        }else{
            return method.invoke(order, args);
        }
        return null;
    }
}
