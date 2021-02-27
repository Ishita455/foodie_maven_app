package com.mycompany.foodieproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

    public static Connection createJdbcConnection(){

        String dbURL = "jdbc:mysql://localhost:3306/foodie";
        String username = "root";
        String password = "";

        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,username,password);

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return conn;
    }
}
