package com.dgd.chainofresponsibility.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 * 定义职责对象接口
 */
public abstract class Handler {
    //持有后续职责对象的引用
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用请求
     * @param userName 申请人的名字
     * @param fee 聚餐费用
     * @return
     */
    public abstract String handlerFeeRequest(String userName, BigDecimal fee);
}
