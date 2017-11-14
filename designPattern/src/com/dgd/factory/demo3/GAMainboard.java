package com.dgd.factory.demo3;

/**
 * @Author DGD
 * @date 2017/10/27.
 * 技嘉的主板
 */
public class GAMainboard implements MainboardApi {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles;

    public GAMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        System.out.println("now in GAMainboard,cpuHoles="+cpuHoles);
    }
}
