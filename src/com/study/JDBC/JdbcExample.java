package com.study.JDBC;

import java.sql.*;

/**
 * @Author : Williams
 * Date : 2023/3/31 10:27
 */
public class JdbcExample {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";
        Connection connection = null;
        try {
            // 1. 加载数据库驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库连接
            connection = DriverManager.getConnection(url, username, password);
            // 3. 取消自动提交事务, 交给手动管理
            connection.setAutoCommit(false);
            // 4. 创建Statement对象
            Statement statement = connection.createStatement();
            // 5. 执行查询操作
            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_task");
            // 6. 处理结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
            // 7. 没有异常则手动提交事务
            connection.commit();
            // 8. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // 有异常则回滚事务. 执行 undolog
            connection.rollback();
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
