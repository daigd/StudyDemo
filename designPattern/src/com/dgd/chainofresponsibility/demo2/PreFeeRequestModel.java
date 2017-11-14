package com.dgd.chainofresponsibility.demo2;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class PreFeeRequestModel extends RequestModel {
    public static final String PRE_FEE = "pre_fee";
    public PreFeeRequestModel() {
        super(PRE_FEE);
    }

    private String userName;
    private BigDecimal preFee;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getPreFee() {
        return preFee;
    }

    public void setPreFee(BigDecimal preFee) {
        this.preFee = preFee;
    }
}
