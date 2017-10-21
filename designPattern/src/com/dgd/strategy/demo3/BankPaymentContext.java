package com.dgd.strategy.demo3;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class BankPaymentContext extends PaymentContext {
    //添加银行卡号
    private String account;

    public BankPaymentContext(PaymentStrategy paymentStrategy, String name, BigDecimal salary, String account) {
        super(paymentStrategy, name, salary);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}
