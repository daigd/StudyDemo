package com.dgd.proxy.staticProxy;

import java.util.List;

/**
 * @Author DaiGuodong
 * @date 2017/10/16.
 * 代理模式的测试类
 */
public class ProxyClient {
    public static void main(String[] args) {

        //代理模式种类一：虚代理
        //这种自己实现的代理方式叫做静态代理
        //使用反射机制实现的代理方式叫做动态代理
        //虚代理：根据需要来创建开销很大的对象,该对象只有在需要的时候才会被真正创建
        UserManager manager = new UserManager();
        List<UserApi>  apiList = manager.getAllUser();
        //如果只是访问ID和姓名,则不需要重新查询数据库
        for (UserApi userApi : apiList) {
            System.out.println("用户ID："+userApi.getUserId()+",用户姓名:"+userApi.getName());
        }
        //如果还要查询其它属性,则需要重新查询数据库
        for (UserApi userApi : apiList) {
            System.out.println("用户ID："+userApi.getUserId()+",用户姓名:"+userApi.getName()+",用户性别:"+userApi.getSex());
        }
    }
}
