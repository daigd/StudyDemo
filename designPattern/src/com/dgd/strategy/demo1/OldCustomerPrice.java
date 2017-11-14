package com.dgd.strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 老客户的报价
 */
public class OldCustomerPrice implements PriceStrategy {
    @Override
    public BigDecimal quote(BigDecimal price) {
        System.out.println("老客户打8折");
        return price.multiply(BigDecimal.valueOf(0.8));
    }
}
