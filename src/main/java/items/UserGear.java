package main.java.items;

import main.java.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static main.java.constants.SQLiteDB.jdbcURL;

// Gear the player has equipped
public class UserGear {

    private String helmet = "wood helmet";
    private String body = "leather chestplate";
    private String shield = "wooden shield";
    private String boots = "leather boots";

    private String weapon = "wooden sword";
    private String weapon2 = "simple bow";

    public UserGear(){

    }

    public void getGearFromDB() {
        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT * FROM userGear WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet userGearResultset = statement.executeQuery(sql);

            // save each result to the array
            while (userGearResultset.next()) {
                this.helmet = userGearResultset.getString("helmet");
                this.body = userGearResultset.getString("body");
                this.shield = userGearResultset.getString("shield");
                this.boots = userGearResultset.getString("boots");

                this.weapon = userGearResultset.getString("weapon");
                this.weapon2 = userGearResultset.getString("weapon2");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }

    public void saveUserGeartoDB() {
        // sql query to update player info
        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "UPDATE userGear SET " +
                    "helmet = '" + this.helmet + "', " +
                    "body = '" + this.body + "', " +
                    "shield = '" + this.shield + "', " +
                    "boots = '" + this.boots + "', " +
                    "weapon = '" + this.weapon + "', " +
                    "weapon2 = '" + this.weapon2 + "' " +
                    "WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            int updated = statement.executeUpdate(sql);

            if (updated == 1){
                System.out.println("user Gear update successful");
            }

            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }



    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getBoots() {
        return boots;
    }

    public void setBoots(String boots) {
        this.boots = boots;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(String weapon2) {
        this.weapon2 = weapon2;
    }

    // todo: create to string method
}
