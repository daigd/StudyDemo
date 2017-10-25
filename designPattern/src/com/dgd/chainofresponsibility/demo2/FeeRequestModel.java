package com.dgd.chainofresponsibility.demo2;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 * 聚餐费用请求对象
 */
public class FeeRequestModel extends RequestModel {
    public static final String FEE_TYPE = "fee";

    public FeeRequestModel() {
        super(FEE_TYPE);
    }

    private String userName;
    private BigDecimal fee;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
