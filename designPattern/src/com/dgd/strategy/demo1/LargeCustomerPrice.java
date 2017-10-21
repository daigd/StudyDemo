package com.dgd.strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 大客户的报价
 */
public class LargeCustomerPrice implements PriceStrategy {
    @Override
    public BigDecimal quote(BigDecimal price) {
        System.out.println("大客户打7折");
        return price.multiply(BigDecimal.valueOf(0.7));
    }
}
