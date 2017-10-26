package com.dgd.factory.demo1;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class IntelCPU implements CPUApi{
    @Override
    public void calcalate() {
        System.out.println("The CPU is IntelCPU.");
    }
}
