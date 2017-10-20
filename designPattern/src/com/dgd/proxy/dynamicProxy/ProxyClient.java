package com.dgd.proxy.dynamicProxy;

/**
 * @Author DGD
 * @date 2017/10/20.
 */
public class ProxyClient {
    public static void main(String[] args) {
        Order order = new Order("设计模式", 10, "张三");
        System.out.println("原始数据:"+order);
        DynamicProxy dynamicProxy = new DynamicProxy();
        OrderApi orderApi = dynamicProxy.getProxyInterface(order);
        orderApi.setOrderNum(20, "李四");
        System.out.println("李四修改："+orderApi);
        orderApi.setOrderNum(30,"张三");
        System.out.println("张三修改:"+orderApi);


    }
}
