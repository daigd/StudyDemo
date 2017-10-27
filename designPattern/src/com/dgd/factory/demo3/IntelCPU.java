package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 */
public class IntelCPU implements CPUApi {
    //CPU针脚数目
    private int pins;

    public IntelCPU(int pins) {
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("now in Intel CPU,pins="+pins);
    }
}
