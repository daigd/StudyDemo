package com.dgd.chainofresponsibility.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class DepManagerHandler extends Handler {
    @Override
    public String handlerFeeRequest(String userName, BigDecimal fee) {
        String result = "";
        //部门经理的权限在1000元以内
        if (BigDecimal.valueOf(1000).compareTo(fee) > 0) {
            if ("小李".equals(userName)) {
                return "部门经理同意"+userName+fee+"元的聚餐费用。";
            }else{
                return "部门经理不同意"+userName+fee+"元的聚餐费用。";
            }
        }else{
            if (successor != null) {
                return successor.handlerFeeRequest(userName, fee);
            }
        }
        return result;
    }
}
