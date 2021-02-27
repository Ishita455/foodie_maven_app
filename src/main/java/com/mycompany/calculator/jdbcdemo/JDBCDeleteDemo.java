package com.mycompany.calculator.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDeleteDemo {
    public static void main(String[] args){
        String dbURL = "jdbc:mysql://localhost:3306/registration";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,username,password);

            String sql = "DELETE FROM Users WHERE username = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"345667");

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0){
                System.out.println("A user has been Deleted Successfully");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
