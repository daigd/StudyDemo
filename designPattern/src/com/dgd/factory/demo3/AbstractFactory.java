package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 定义抽象工厂的接口
 */
public interface AbstractFactory {
    //提供创建CPU的方法
    CPUApi createCPUApi();

    //提供创建主板的方法
    MainboardApi createMainboardApi();
}
