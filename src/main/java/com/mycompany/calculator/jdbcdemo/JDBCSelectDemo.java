package com.mycompany.calculator.jdbcdemo;

import java.sql.*;

public class JDBCSelectDemo {
    public static void main(String[] args){
        String dbURL = "jdbc:mysql://localhost:3306/registration";
        String username = "root";
        String password = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL,username,password);
            String sql = "SELECT * FROM Users";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                String name = result.getString(2);
                String pass = result.getString(3);
                String fullname = result.getString("fullname");
                String email = result.getString("email");

                String format = "User #%d: %s - %s - %s - %s";
                String formattedOutput = String.format(format, ++count,name,pass,fullname,email);
                System.out.println(formattedOutput);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
