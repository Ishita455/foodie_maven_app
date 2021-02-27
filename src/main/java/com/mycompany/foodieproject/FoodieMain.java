package com.mycompany.foodieproject;

import com.mycompany.foodieproject.categorysql.CategoryCrud;
import com.mycompany.foodieproject.menusql.MenuCrud;
import com.mycompany.foodieproject.usersql.UserCrud;

import java.sql.SQLException;
import java.util.Scanner;

public class FoodieMain {

    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void options() {
        System.out.println("0 : New User Registration");
        System.out.println("1 : User Login");
        System.out.println("2 : Show All Menu");
        System.out.println("3 : Show Menu for a category");
        System.out.println("4 : Order 1 or more menu items");
        System.out.println("5 : Total bill for order with order details");
        System.out.println("6 : Exit the Program");
        System.out.println("\n Enter the Choice");
        choice = scanner.nextInt();
    }

    public static void main(String[] args) throws SQLException {

        CategoryCrud categoryCrud = new CategoryCrud();

        Category c = categoryCrud.getCategoryById(3);
        System.out.println(c.getName());


        while (true) {

            options();

            switch (choice){

                case 0:
                    System.out.println("New Registrations");
                    UserCrud userCrud = new UserCrud();
                    User u = userCrud.newUserRegistration();

                case 1:
                    System.out.println("Login");
                    UserCrud usersCrud = new UserCrud();
                    User ul = usersCrud.userLogin();

                case 2:
                    System.out.println("Show all available");
                    MenuCrud menuCrud = new MenuCrud();
                    Menu m = (Menu) menuCrud.getAllMenu();

                case 3:
                    System.out.println("Show menu for a category");
                    System.out.println("print the category");


            }
        }
    }
}
