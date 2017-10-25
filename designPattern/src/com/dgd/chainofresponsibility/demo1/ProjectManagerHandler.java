package com.dgd.chainofresponsibility.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class ProjectManagerHandler extends Handler {
    @Override
    public String handlerFeeRequest(String userName, BigDecimal fee) {
        //项目经理只能处理500元以下的请求
        String result = "";
        if (BigDecimal.valueOf(500).compareTo(fee) > 0) {
            //只同意小李的请求
            if ("小李".equals(userName)) {
                return "项目经理同意"+userName+fee+"元的聚餐申请。";
            }else{
                return "项目经理不同意"+userName+"的聚餐申请。";
            }
        }else{
            //其它额度交由下一个对象处理
            if (this.successor != null) {
                return successor.handlerFeeRequest(userName, fee);
            }
        }
        return result;
    }
}
