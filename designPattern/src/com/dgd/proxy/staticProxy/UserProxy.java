package com.dgd.proxy.staticProxy;

import com.dgd.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author DaiGuodong
 * @date 2017/10/16.
 * 代理对象,代理用户数据对象
 */
public class UserProxy implements UserApi{
    //实际对象
    private UserModel userModel = null;
    //标识是否已经装载过数据
    private boolean loaded = false;

    public UserProxy(UserModel userModel) {
        this.userModel = userModel;
    }
    @Override
    public void setUserId(Integer userId) {
        this.userModel.setUserId(userId);
    }

    @Override
    public Integer getUserId() {
        return userModel.getUserId();
    }

    @Override
    public void setName(String name) {
        this.userModel.setName(name);
    }

    @Override
    public String getName() {
        return userModel.getName();
    }

    @Override
    public void setAge(Integer age) {
        userModel.setAge(age);
    }

    @Override
    public Integer getAge() {
        //如果没有装载过数据,则从数据库中读取
        if (!loaded) {
            reload();
            this.loaded = true;
        }
        return userModel.getAge();
    }

    @Override
    public void setSex(String sex) {
        userModel.setSex(sex);
    }

    @Override
    public String getSex() {
        if (!loaded) {
            reload();
            this.loaded = true;
        }
        return userModel.getSex();
    }

    @Override
    public String toString() {
        return "userId="+getUserId()+",name="+getName()+",age="+getAge()+",sex="+getSex();
    }

    /**
     * 从数据库装载数据
     */
    private void reload() {
        System.out.println("重新查询数据库获取完整数据,userId="+getUserId());

        //利用JDBC的方式连接数据库
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT age,sex from t_user where user_id = ?";
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1,userModel.getUserId());
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                //只要获取userId和name之外的属性就可以了
                userModel.setAge(rs.getInt("age"));
                userModel.setSex(rs.getString("sex"));
            }
            rs.close();
            prst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection getConnection() throws Exception{
        return DBUtil.getConnection();
    }
}
