package com.dgd.strategy.demo2;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class StrategyClient {
    public static void main(String[] args) {
        LogContext context = new LogContext();
        context.log("管理员添加");
        context.log("普通管理员添加");
    }
}
