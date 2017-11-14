package com.dgd.strategy.demo3;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class PaymentClient {
    public static void main(String[] args) {
        //现金支付
        RMBCash rmbCash = new RMBCash();
        PaymentContext paymentContext = new PaymentContext(rmbCash, "张三", BigDecimal.TEN);
        paymentContext.payNow();

        DollarCash dollarCash = new DollarCash();
        paymentContext = new PaymentContext(dollarCash, "李四", BigDecimal.TEN);
        paymentContext.payNow();

        //现在要用银行转账支付,需要多添加一个参数:银行卡号
        //第一个实现方式:扩展PaymentContext上下文环境类:子类添加银行卡号的参数即可
        BankCash bankCash = new BankCash();
        paymentContext = new BankPaymentContext(bankCash, "李四", BigDecimal.TEN, "12345");
        paymentContext.payNow();

        //第二种方式:扩展实现算法,在转账类里添加银行卡号
        BankCashWithAccount bankCashWithAccount = new BankCashWithAccount("23456");
        paymentContext = new PaymentContext(bankCashWithAccount, "王五", BigDecimal.TEN);
        paymentContext.payNow();

        //两种实现方式比较:
        //第一种方式保持了策略算法实现风格上的统一,缺点则是添加的公共数据,如果别的策略算法用不上的话,则显得浪费
        //第二种方式优缺点则刚好跟第一种方式相反:数据有一部分来自上下文,有一部分来自策略算法,造成客户端调用策略方式的不统一
        //两种方式采用哪种,具体视实际情况而定

    }
}
