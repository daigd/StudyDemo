package com.dgd.facade;

/**
 * @author Dgd
 * @Description 客户端调用保安系统
 * @date 2018-05-04 15:51
 */
public class Client {
    public static void main(String[] args) {
        SecurityFacade facade = new SecurityFacade();
        System.out.println("开启保安系统:");
        facade.activate();
        System.out.println("关闭保安系统:");
        facade.deactivate();
    }
}
