package main.java.items;

import main.java.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static main.java.constants.SQLiteDB.jdbcURL;

// items the player has in storage
public class StorageItems {

    public static ArrayList<Item> storageItems = new ArrayList<>();

    public static void getAllItemsFromDB() {

        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT * FROM storage WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet storageResultset = statement.executeQuery(sql);

            // save each result to the array
            while (storageResultset.next()) {
                Item item = new Item();
                item.setItemName(storageResultset.getString("itemName"));
                item.setItemType(storageResultset.getString("itemType"));
                int quantity = storageResultset.getInt("itemQty");

                for (int i = quantity; i > 0; i--) {
                    storageItems.add(item);
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
