package com.mycompany.foodieproject.categorysql;

import com.mycompany.foodieproject.Category;
import com.mycompany.foodieproject.utility.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryCrud {

    public Category getCategoryById(Integer categoryId){

        Connection connection = JdbcConnection.createJdbcConnection();
        Category category = new Category();
        try {
            String sql = "SELECT * FROM category WHERE category_id="+categoryId;

            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, categoryId);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                Integer catId = result.getInt("category_id");
                String catName = result.getString("category_name");

                category.setCategoryId(catId);
                category.setName(catName);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    public List<Category> getAllCategories(){

        Connection connection = JdbcConnection.createJdbcConnection();
        Category category = null;
        List<Category> allCategories = new ArrayList<>();
         try {
            String sql = "SELECT * FROM category";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                Integer catId = result.getInt("category_id");
                String catName = result.getString("category_name");

                category = new Category();
                category.setCategoryId(catId);
                category.setName(catName);

                allCategories.add(category);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allCategories;
    }
}
