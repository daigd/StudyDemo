package com.dgd.proxy.dynamicProxy;

import java.io.Serializable;

/**
 * @Author DGD
 * @date 2017/10/21.
 */
public interface OrderApi extends Serializable {

    void setProductName(String productName, String user);

    String getProductNmae();

    void setOrderNum(int orderNum, String user);

    int getOrderNum();

    void setOrderUser(String orderUser, String user);

    String getOrderUser();
}
