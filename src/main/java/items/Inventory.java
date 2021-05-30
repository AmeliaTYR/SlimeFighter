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

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }

    public static void saveInventorytoDB(){
        // wipe existing data using query
        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "DELETE FROM inventory WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            int deleted = statement.executeUpdate(sql);

            if (deleted != 0){
                System.out.println("user inventory wipe successful");
            }

            ArrayList<Item> itemCounts = new ArrayList<>();

            if (inventoryItems.size() > 1){

                inventoryItems.sort(new ItemComparator()); // sorting works


                String newItemName = inventoryItems.get(0).getItemName();
                String currentItemName = newItemName;

                Item firstItem = inventoryItems.get(0);
                firstItem.setItemQty(0);

                itemCounts.add(firstItem);

                // for each item type, count total, save as temp arraylist
                for (int j = 0; j < inventoryItems.size(); j++) {

                    newItemName = inventoryItems.get(j).getItemName();

                    if (currentItemName.equals(newItemName)){
                        int itemIndex = ItemFns.getFirstItemIndexByName(newItemName, itemCounts);
                        System.out.println(itemIndex);
                        int itemQtyNew = itemCounts.get(itemIndex).getItemQty() + 1;
                        itemCounts.get(itemIndex).setItemQty(itemQtyNew);
                    } else {
                        currentItemName = newItemName;
                        Item temp = inventoryItems.get(j);
                        temp.setItemQty(1);
                        itemCounts.add(temp);
                    }
                }

                System.out.println(itemCounts);

                // add each set of item in the temp array list

            } else if (inventoryItems.size() == 1){
                itemCounts.add(inventoryItems.get(0));
            } else {
                return;
            }


            for (int k = 0; k < itemCounts.size(); k++){
                String sql2 = "INSERT INTO inventory (userName, itemQty, itemType, itemName) VALUES (\"" +
                        Main.currentUser.getUsername() + "\", " +
                        itemCounts.get(k).getItemQty() + ", \"" +
                        itemCounts.get(k).getItemType() + "\", \"" +
                        itemCounts.get(k).getItemName() + "\");";
                statement.addBatch(sql2);

            }

            statement.executeBatch();

            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }


    }


}
