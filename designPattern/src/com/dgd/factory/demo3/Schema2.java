package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 第二种装机方案:AMD的CPU+微星的主板
 */
public class Schema2 implements AbstractFactory{
    @Override
    public CPUApi createCPUApi() {
        return new AMDCpu(939);
    }

    @Override
    public MainboardApi createMainboardApi() {
        return new MSIMainboard(939);
    }
}
