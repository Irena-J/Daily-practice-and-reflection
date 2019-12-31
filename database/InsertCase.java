package com.shy.mysql;

import java.sql.*;


public class InsertCase {
    public static void createBases(){
    Connection connection = null;
    Statement stmt = null;
        try {
        //加载数据库驱动,利用的是反射机制
        Class.forName("com.mysql.jdbc.Driver");//这个路径固定
        //获取一个连接
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
        stmt = connection.createStatement();
        stmt.execute("create database learn_1230");
        //stmt.execute("drop database my_jdbc_db");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        finally {

        try {
            if(stmt != null){
                stmt.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    public static void createTable() {

        Connection connection = null;
        Statement stmt = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/learn_1230","root","");
            //创建语句对象
            stmt = connection.createStatement();
            //执行
            String sql = "create table"+" jdbcTab(col1 int,col2 varchar(20))";
            stmt.execute(sql);
            //关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void insertIntoTable(){
        Connection connection = null;
        Statement stmt = null;

        //加载驱动

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/learn_1230","root","123456");
            //创建语句对象
            stmt = connection.createStatement();
            //执行
            String sql = "insert into jdbcTab(col1,col2) values(1,'thy')";
            stmt.execute(sql);
            //关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectTable(){
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        //加载驱动

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/learn_1230","root","123456");
            //创建语句对象
            stmt = connection.createStatement();
            //执行
            String sql = "select * from jdbcTab";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Integer col1 = rs.getInt("col1");
                String col2 = rs.getString("col2");
                System.out.println("col1="+col1+"col2="+col2);
            }
            //关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
       createBases();
        createTable();
        insertIntoTable();
        selectTable();
    }
}
