package com.xh;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.*;

public class JDBCTest {
    @ParameterizedTest
    @CsvSource({"xiaoqiao,123456","zhangsan,123456"})
    public void test(String uname,String pwd) throws ClassNotFoundException, SQLException {
        //1.准备工作
        //  注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");  //固定操作
        //  获取数据库驱动对象 Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db01", "root", "root");
        //  获取SQL语句执行对象 Statement
        //  Statement statement = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement("select * from user where username = ? and password = ?");
        //  设置参数值
        ps.setString(1, uname);
        ps.setString(2, pwd);

        //2.执行sql语句
//        int i = statement.executeUpdate("update user set password = '12345678' where id = '1';");
//        System.out.println("i="+i);
//        ResultSet resultSet = statement.executeQuery("select * from user where username = '"+uname+"' && password = '"+pwd+"'");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            Integer age = resultSet.getInt("age");
            User user = new User(id, username, password, name, age);
            System.out.println(user);
        }
        //3.释放资源
        connection.close();
        ps.close();
    }
}
