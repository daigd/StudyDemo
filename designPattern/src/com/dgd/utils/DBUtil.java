package com.dgd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author DaiGuodong
 * @date 2017/10/16.
 * 数据库相关操作
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://219.128.77.92:14805/test?useUnicode=true&amp;characterEncoding=UTF-8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "j58k9rptn7qw4";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
