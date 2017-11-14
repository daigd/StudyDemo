package com.dgd.command.demo2;

/**
 * @Author DGD
 * @date 2017/11/1.
 * 真正计算功能的实现者
 */
public class Operation implements OperationApi {
    private int result;
    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void add(int num) {
        result += num;
    }

    @Override
    public void substract(int num) {
        result -= num;
    }
}
