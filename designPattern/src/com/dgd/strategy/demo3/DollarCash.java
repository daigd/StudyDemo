package com.dgd.strategy.demo3;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class DollarCash implements PaymentStrategy {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("现在给"+context.getName()+"美金支付"+context.getSalary()+"元");
    }
}
