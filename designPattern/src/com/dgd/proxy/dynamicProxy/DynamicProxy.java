package com.dgd.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class DynamicProxy implements InvocationHandler {
    //具体要代理的对象
    private Order order;

    public OrderApi getProxyInterface(Order order) {
        this.order = order;
        //返回具体 对象的接口
        OrderApi orderApi = (OrderApi) Proxy.newProxyInstance(order.getClass().getClassLoader(), order.getClass().getInterfaces(), this);
        return orderApi;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过方法名判断,如果是设值的方法,只能是创建者才允许修改
        if (method.getName().startsWith("set")) {
            if (!order.getOrderUser().equals(args[1])) {
                System.out.println(args[1]+"您不允许修改数据!");
            }else{
                method.invoke(order, args);
            }
        }else{
            method.invoke(order, args);
        }
        return null;
    }
}
