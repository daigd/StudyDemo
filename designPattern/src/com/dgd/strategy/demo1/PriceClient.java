package com.dgd.strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class PriceClient {
    public static void main(String[] args) {
        BigDecimal price = BigDecimal.valueOf(100);
        //选择需要的报价策略
        PriceStrategy priceStrategy = new LargeCustomerPrice();
        //创建报价的上下文
        PriceContext context = new PriceContext(priceStrategy);
        //计算报价
        System.out.println("原价:"+price);
        System.out.println("向客户报价:"+context.quote(price));
    }
}
