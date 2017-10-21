package com.dgd.proxy.dynamicProxy;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public class Order implements OrderApi {
    private String productName;
    private int orderNum;
    private String orderUser;

    public Order(String productName, int orderNum, String orderUser) {
        this.productName = productName;
        this.orderUser = orderUser;
        this.orderNum = orderNum;
    }
    public void setProductName(String productName, String user) {
        this.productName = productName;
    }

    public String getProductNmae() {
        return productName;
    }

    public void setOrderNum(int orderNum, String user) {
        this.orderNum = orderNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderUser(String orderUser, String user) {
        this.orderUser = orderUser;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public String toString() {
        return "productName="+productName+",orderNum="+orderNum+",orderUser="+orderUser;
    }
}
