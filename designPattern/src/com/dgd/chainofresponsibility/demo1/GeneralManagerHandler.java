package com.dgd.chainofresponsibility.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class GeneralManagerHandler extends Handler {
    @Override
    public String handlerFeeRequest(String userName, BigDecimal fee) {
        //总经理权限比较大,可以处理任意金额的申请
        if ("小李".equals(userName)) {
            return "总经理同意"+userName+fee+"元的聚餐费用。";
        }else {
            return "总经理不同意"+userName+fee+"元的聚餐费用。";
        }
    }
}
