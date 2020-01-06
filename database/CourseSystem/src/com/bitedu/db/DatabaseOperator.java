package com.bitedu.db;


import com.bitedu.data.Student;
import com.bitedu.data.Take;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperator {
    private static String URL = "jdbc:mysql://localhost/course_system";
    private static String USER = "root";
    private static String PASSWORD = "";

    public static MysqlDataSource getDataSourse(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
    //插入学生表
    public static void insertStudent(Student stu){
        //1 获取数据源
        Connection connection = null;
        PreparedStatement pstmt = null;

        try{
            connection = getDataSourse().getConnection();
            String sql = "insert into student(sno,name,classid) values(?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,stu.getSno());
            pstmt.setString(2,stu.getName());
            pstmt.setInt(3,stu.getClassid());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                } if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //查询学生表
    public static Student selectStudent(int sno){
        //1 获取数据源
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student stu2 = new Student();
        try{
            connection = getDataSourse().getConnection();
            String sql = "select sno,sname,classid from stu_dent where sno = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,sno);

            rs = pstmt.executeQuery();

            while(rs.next()){
                stu2.setSno(rs.getInt("sno"));
                stu2.setName(rs.getString("name"));
                stu2.setClassid(rs.getInt("classid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                } if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return stu2;
    }


    public static Take selectScoreStudent(int score){
        //1 获取数据源
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Take take = new Take();
        try{
            connection = getDataSourse().getConnection();
            String sql = "select score,count(score) as count_score  from take group by score having score > ?;";//?传入要大于的分数
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,score);
            //parameterindex:表示的sql语句中第几个？
            rs = pstmt.executeQuery();

            while(rs.next()){
                take.setScore(rs.getInt("score"));
                take.setCount(rs.getInt("count_score"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                } if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return take;
    }


}
