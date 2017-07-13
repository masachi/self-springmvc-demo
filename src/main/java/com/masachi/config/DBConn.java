package com.masachi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by masachi on 2017/7/13.
 */
public class DBConn {
    public static Connection connection;
    public static Statement statement;

    public void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            String url = "jdbc:mysql://182.254.152.66:3306/graduate?useUnicode=true&characterEncoding=utf8&autoReconnect=true&connectTimeout=0";    //JDBC的URL
            connection = DriverManager.getConnection(url, "root", "sizhaizhenexin");
            if(connection != null) {
                System.out.println("成功连接到数据库！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
