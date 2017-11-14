package com.dgd.chainofresponsibility.demo2;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class Client {
    public static void main(String[] args) {
        //聚餐费
        FeeRequestModel rm = new FeeRequestModel();
        rm.setUserName("小李");
        rm.setFee(BigDecimal.TEN);

        Handler handler = new ProjectManagerHandler();
        System.out.println(handler.handlerRequest(rm));

        rm.setFee(BigDecimal.valueOf(800));
        System.out.println(handler.handlerRequest(rm));

        //差旅费
        PreFeeRequestModel pfm = new PreFeeRequestModel();
        pfm.setUserName("小张");
        pfm.setPreFee(BigDecimal.TEN);

        handler = new ProjectManagerHandler2();
        System.out.println(handler.handlerRequest(pfm));


    }
}
