package com.dgd.proxy.staticProxy;

import java.io.Serializable;

/**
 * @Author DaiGuodong
 * @date 2017/10/16.
 * 定义用户对象接口
 */
public interface UserApi extends Serializable{
    void setUserId(Integer userId);
    Integer getUserId();
    void setName(String name);
    String getName();
    void setAge(Integer age);
    Integer getAge();
    void setSex(String sex);
    String getSex();
}
