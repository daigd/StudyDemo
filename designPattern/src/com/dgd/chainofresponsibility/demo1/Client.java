package com.dgd.chainofresponsibility.demo1;

import java.math.BigDecimal;

/**
 * @Author DGD
 * @date 2017/10/25.
 */
public class Client {
    public static void main(String[] args) {
        //1,先组装职责对象
        Handler h1 = new ProjectManagerHandler();
        Handler h2 = new DepManagerHandler();
        Handler h3 = new GeneralManagerHandler();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        //发送请求
        System.out.println(h1.handlerFeeRequest("小李", BigDecimal.TEN));
        System.out.println(h1.handlerFeeRequest("小要", BigDecimal.TEN));

        System.out.println(h1.handlerFeeRequest("小李", BigDecimal.valueOf(600)));
        System.out.println(h1.handlerFeeRequest("小要", BigDecimal.valueOf(600)));

        System.out.println(h1.handlerFeeRequest("小李", BigDecimal.valueOf(1500)));
        System.out.println(h1.handlerFeeRequest("小要", BigDecimal.valueOf(1500)));
    }
}
