package com.mycompany.foodieproject.usersql;

import com.mycompany.foodieproject.User;
import com.mycompany.foodieproject.utility.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCrud<rowInserted> {
    Connection connection = JdbcConnection.createJdbcConnection();
    User user = null;
    List<User> allUser = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


  public User newUserRegistration() throws SQLException {
        String sql = "INSERT INTO user (user_name,user_email,user_password,user_address) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.println("Enter the User Name");
        String user_name = scanner.nextLine();

        System.out.println("Enter the User Email");
        String user_email = scanner.nextLine();

        System.out.println("Enter the User Password");
        String user_password = scanner.nextLine();

        System.out.println("Enter the User Address");
        String user_address = scanner.nextLine();

        statement.setString(1, user_name);
        statement.setString(2, user_email);
        statement.setString(3, user_password);
        statement.setString(4, user_address);


        int rowInserted = statement.executeUpdate();
        if (rowInserted > 0) {
            System.out.println("A new User Added Successfully");
        }
      return null;
  }

    public User userLogin() throws SQLException {
        String sql = "SELECT * FROM user";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){

            String eID = result.getString("email_id");
            String pssd = result.getString("password");


            user = new User();
            user.setEmail_id(eID);
            user.setPassword(pssd);

            if (eID.equals(user.getEmail_id())&& pssd.equals(user.getPassword())){
                System.out.println("Login Successfull");
            }
            else {
                System.out.println("Not registered!");
            }


        }
        return user;
    }

    public UserCrud() throws SQLException {


    }
}

