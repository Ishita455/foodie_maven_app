package com.mycompany.calculator.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdateDemo {
    public static void main(String[] args){
        String dbURL = "jdbc:mysql://localhost:3306/registration";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,username,password);

            String sql = "UPDATE Users SET password=?,username=?,email=? WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "234567");
            statement.setString(2,"Ishita Rathod");
            statement.setString(3,"ishitarathod@gmail.com");
            statement.setString(4,"123456789");

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0){
                System.out.println("An Existing users were updated");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
