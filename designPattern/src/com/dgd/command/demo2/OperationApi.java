package com.dgd.command.demo2;

/**
 * @Author DGD
 * @date 2017/11/1.
 */
public interface OperationApi {
    //获取计算后的结果
    int getResult();
    //设置开始计算的初始值
    void setResult(int result);

    /**
     * 加法
     * @param numm 要加的数
     */
    void add(int numm);

    /**
     * 减法
     * @param num 要减的数
     */
    void substract(int num);
}
