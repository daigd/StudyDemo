package com.dgd.strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 普通客户的报价
 */
public class NormalCustomerPrice implements PriceStrategy {
    @Override
    public BigDecimal quote(BigDecimal price) {
        System.out.println("普通客户原价");
        return price;
    }
}
