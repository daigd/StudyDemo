package com.dgd.strategy.demo3;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 工资支付接口
 */
public interface PaymentStrategy {
    //因为参数不确定,通过上下文来获取需要的参数
    void pay(PaymentContext context);
}
