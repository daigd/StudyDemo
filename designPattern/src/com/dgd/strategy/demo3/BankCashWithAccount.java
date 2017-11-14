package com.dgd.strategy.demo3;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class BankCashWithAccount implements PaymentStrategy {
    private String account;

    public BankCashWithAccount(String account) {
        this.account = account;
    }
    @Override
    public void pay(PaymentContext context) {
        System.out.println("现在给"+context.getName()+"银行转账"+context.getSalary()+"元,卡号为:"+account);
    }
}
