package com.dgd.factory.demo1;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class Client {
    public static void main(String[] args) {
        CPUApi cpuApi = CPUFactory.createCPU();
        cpuApi.calcalate();
    }
}
