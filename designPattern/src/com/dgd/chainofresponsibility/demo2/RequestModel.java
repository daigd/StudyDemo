package com.dgd.chainofresponsibility.demo2;

/**
 * @Author DGD
 * @date 2017/10/25.
 * 定义一个通用的请求对象
 */
public class RequestModel {
    //表示具体的业务类型
    private String type;

    public RequestModel(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
