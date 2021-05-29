package main.java.items;

import main.java.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static main.java.constants.SQLiteDB.jdbcURL;

// items the player has on hand
public class Inventory {

    public static ArrayList<Item> inventoryItems = new ArrayList<>();

    public static void getAllItemsFromDB() {

        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT * FROM inventory WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet inventoryResultset = statement.executeQuery(sql);

            // save each result to the array
            while (inventoryResultset.next()) {
                Item item = new Item();
                item.setItemName(inventoryResultset.getString("itemName"));
                item.setItemType(inventoryResultset.getString("itemType"));
                int quantity = inventoryResultset.getInt("itemQty");

                for (int i = quantity; i > 0; i--) {
                    inventoryItems.add(item);
                }

                System.out.println(" item: " + item.getItemName() +
                        ", type: " + item.getItemType() +
                        " added " + quantity + " times"
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }

    public static void saveInventorytoDB(){
        // wipe existing data using query
        // for each item type, count total, save as temp arraylist
        // add each set of item in the temp array list
    }

    // todo: create to string method


}
