package com.dgd.proxy.dynamicProxy;

/**
 * @Author DGD
 * @date 2017/10/20.
 * 订单接口
 */
public interface OrderApi {
    //设置产品名称
    void setProductName(String productName,String orderUser);
    String getProductName();

    //设置产品数量
    void setOrderNum(int orderNum,String orderUser);

    int getOrderNum();

    //设置操作人员
    void setOrderUser(String otherUser,String orderUser);

    String getOrderUser();


}
