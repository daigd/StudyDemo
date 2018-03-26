package com.dgd.factory.demo1;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class CPUFactory {
    public static CPUApi createCPU() {
        CPUApi api = null;
        try {
            api = (CPUApi) Class.forName("com.dgd.factory.demo1.IntelCPU").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return api;
    }
}
