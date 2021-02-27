package com.mycompany.calculator.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertDemo {

    public static void main(String[] args){
        String dbURL = "jdbc:mysql://localhost:3306/registration";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,username,password);

            String sql = "INSERT INTO Users (username,password,fullname,email) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"ish");
            statement.setString(2,"1234567");
            statement.setString(3,"Ishita Rathod");
            statement.setString(4,"ishitarathod@gmail.com");

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0){
                System.out.println("A new User Added Successfully");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}



