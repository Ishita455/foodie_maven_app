package com.mycompany.foodieproject.menusql;

import com.mycompany.foodieproject.Menu;
import com.mycompany.foodieproject.utility.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuCrud {

    public Menu getMenubyId(Integer menuId){

        Connection connection = JdbcConnection.createJdbcConnection();
        Menu menu = new Menu();
        try {
            String sql = "SELECT * FROM menu WHERE menu_id="+menuId;

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                Integer mID = result.getInt("menu_id");
                String mName = result.getString("menu_name");
                String mDesc = result.getString("menu_description");
                Double mup = result.getDouble("unit_price");

                menu.setMenuId(mID);
                menu.setMenuName(mName);
                menu.setMenuDescription(mDesc);
                menu.setUnitPrice(mup);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return menu;
    }

    public List<Menu> getAllMenu(){

        Connection connection = JdbcConnection.createJdbcConnection();
        Menu menu = null;
        List<Menu> allMenu = new ArrayList<>();
        try {
            String sql = "SELECT * FROM menu";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                Integer mId = result.getInt("menu_id");
                String mName = result.getString("menu_name");
                String mDesc = result.getString("menu_description");
                Double mup = result.getDouble("unit_price");

                menu = new Menu();
                menu.setMenuId(mId);
                menu.setMenuName(mName);
                menu.setMenuDescription(mDesc);
                menu.setUnitPrice(mup);

                allMenu.add(menu);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allMenu;
    }
}
