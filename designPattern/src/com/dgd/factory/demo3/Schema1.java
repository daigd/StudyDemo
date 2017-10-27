package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 第一种电脑组装实现:Intel的CPU+技嘉的主板
 */
public class Schema1 implements AbstractFactory {
    @Override
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }

    @Override
    public MainboardApi createMainboardApi() {
        return new GAMainboard(1156);
    }
}
