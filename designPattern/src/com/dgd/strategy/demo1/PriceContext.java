package com.dgd.strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 报价上下文
 */
public class PriceContext {
    private PriceStrategy priceStrategy;

    public PriceContext(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public BigDecimal quote(BigDecimal price) {
        //根据不同的客户采取不同的报价方式
        return priceStrategy.quote(price);
    }
}
