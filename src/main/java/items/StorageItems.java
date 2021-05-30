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

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }

    // for testing
    public static void addWater(){
        Item newItem = new Item();
        newItem.setItemName("donut");
        newItem.setItemType("consumable");
        newItem.setItemQty(1);
        storageItems.add(newItem);
    }

    public static void saveStorageToDB(){
        // wipe existing data using query
        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "DELETE FROM storage WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            int deleted = statement.executeUpdate(sql);

            if (deleted != 0){
                System.out.println("Wipe successful");
            }

            ArrayList<Item> itemCounts = new ArrayList<>();

            if (storageItems.size() > 1){

                storageItems.sort(new ItemComparator()); // sorting works


                String newItemName = storageItems.get(0).getItemName();
                String currentItemName = newItemName;

                Item firstItem = storageItems.get(0);
                firstItem.setItemQty(0);

                itemCounts.add(firstItem);

                // for each item type, count total, save as temp arraylist
                for (int j = 0; j < storageItems.size(); j++) {

                    newItemName = storageItems.get(j).getItemName();

                    if (currentItemName.equals(newItemName)){
                        int itemIndex = ItemFns.getFirstItemIndexByName(newItemName, itemCounts);
                        System.out.println(itemIndex);
                        int itemQtyNew = itemCounts.get(itemIndex).getItemQty() + 1;
                        itemCounts.get(itemIndex).setItemQty(itemQtyNew);
                    } else {
                        currentItemName = newItemName;
                        Item temp = storageItems.get(j);
                        temp.setItemQty(1);
                        itemCounts.add(temp);
                    }
                }

                System.out.println(itemCounts);

                // add each set of item in the temp array list

            } else if (storageItems.size() == 1){
                itemCounts.add(storageItems.get(0));
            } else {
                return;
            }


            for (int k = 0; k < itemCounts.size(); k++){
                String sql2 = "INSERT INTO storage (userName, itemQty, itemType, itemName) VALUES (\"" +
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
