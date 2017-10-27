package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 装机工程师
 */
public class ComputerEngineer {
    private CPUApi cpuApi;
    private MainboardApi mainboardApi;

    public void makeComputer(AbstractFactory schema) {
        //1,准备好电脑配件
        prepareHardwares(schema);
        //2,组装电脑
        //3,测试电脑
        //4,交付用户
    }

    private void prepareHardwares(AbstractFactory schema) {
        //使用抽象工厂来获取相关组件
        this.cpuApi = schema.createCPUApi();
        this.mainboardApi = schema.createMainboardApi();

        //测试组件是否好用
        this.cpuApi.calculate();
        this.mainboardApi.installCPU();
    }
}
