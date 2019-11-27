package com.mybatis;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @Author: 张惊涛 on 2019/11/27 09:07
 * @Description:
 */
public class TestJdbc {

  static {
    try {
      /*加载驱动*/
      Class.forName(Driver.class.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "root");
    PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
    preparedStatement.setString(1,"1");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()){
      String id = resultSet.getMetaData().getColumnName(1);
      String name = resultSet.getMetaData().getColumnName(2);
      System.out.println(id+":"+resultSet.getString(1));
      System.out.println(name+":"+resultSet.getString(2));
    }
    resultSet.close();
    preparedStatement.close();
    connection.close();
  }
}
