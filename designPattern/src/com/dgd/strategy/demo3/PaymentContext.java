package com.dgd.strategy.demo3;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class PaymentContext {
    //员工姓名
    private String name;
    //支付给员工的工资
    private BigDecimal salary;

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy, String name, BigDecimal salary) {
        this.paymentStrategy = paymentStrategy;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 立即支付工资
     */
    public void payNow() {
        paymentStrategy.pay(this);
    }
}
