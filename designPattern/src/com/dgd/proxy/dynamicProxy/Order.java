package com.dgd.proxy.dynamicProxy;

/**
 * @Author DGD
 * @date 2017/10/20.
 */
public class Order implements OrderApi{
    private String productName;
    private int orderNum;
    private String orderUser;

    public Order(String productName, int orderNum, String orderUser) {
        this.productName=productName;
        this.orderNum = orderNum;
        this.orderUser = orderUser;
    }

    @Override
    public void setProductName(String productName, String orderUser) {
        this.productName = productName;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setOrderNum(int orderNum, String orderUser) {
        this.orderNum = orderNum;
    }

    @Override
    public int getOrderNum() {
        return orderNum;
    }

    @Override
    public void setOrderUser(String otherUser, String orderUser) {
        this.orderUser = orderUser;
    }

    @Override
    public String getOrderUser() {
        return orderUser;
    }

    @Override
    public String toString() {
        return "productName="+productName+",orderNum="+orderNum+",orderUser="+orderUser;
    }
}
