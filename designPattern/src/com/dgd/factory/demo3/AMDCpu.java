package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 */
public class AMDCpu implements CPUApi {
    private int pins;

    public AMDCpu(int pins) {
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("now in AMD CPU,pins="+pins);
    }
}
