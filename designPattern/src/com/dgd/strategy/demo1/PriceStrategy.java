package com.dgd.strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 报价接口
 */
public interface PriceStrategy {
    BigDecimal quote(BigDecimal price);
}
