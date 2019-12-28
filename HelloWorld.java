package com.shy.edu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {
    public static void main(String[] args) {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");//这个路径固定
            //获取一个连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost","root","");
            Statement stmt = connection.createStatement();
            stmt.execute("create database my_jdbc_db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
