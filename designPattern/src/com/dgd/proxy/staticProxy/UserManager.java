package com.dgd.proxy.staticProxy;

import com.dgd.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author DaiGuodong
 * @date 2017/10/16.
 */
public class UserManager {
    public List<UserApi> getAllUser() {
        List<UserApi> userApiList = new ArrayList<>();
        Connection conn = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT user_id  as userId,name from t_user";
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                //使用的是代表对象,不是真正的UserProxy对象
                UserProxy userProxy = new UserProxy(new UserModel());
                //只需要设置userId和name就可以了
                userProxy.setUserId(rs.getInt("userId"));
                userProxy.setName(rs.getString("name"));
                userApiList.add(userProxy);
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userApiList;
    }
}
