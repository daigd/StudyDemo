package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 微星的主板
 */
public class MSIMainboard implements MainboardApi {
    private int cpuHoles;

    public MSIMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        System.out.println("now in MSIMainboard,cpuholes="+cpuHoles);
    }
}
