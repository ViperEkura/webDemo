package com.elm.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Properties props = new Properties();
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
            if (inputStream == null) {
                throw new RuntimeException("无法找到配置文件 db.properties");
            }
            props.load(inputStream);
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            System.err.println("初始化数据库连接失败：" + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}