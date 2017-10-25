package com.dgd.chainofresponsibility.demo2;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class Client {
    public static void main(String[] args) {
        FeeRequestModel rm = new FeeRequestModel();
        rm.setUserName("小李");
        rm.setFee(BigDecimal.TEN);

        Handler handler = new ProjectManagerHandler();
        System.out.println(handler.handlerRequest(rm));

        rm.setFee(BigDecimal.valueOf(800));
        System.out.println(handler.handlerRequest(rm));
    }
}
