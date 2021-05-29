package main.java.items;

import main.java.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static main.java.constants.SQLiteDB.jdbcURL;

public class StatusEffectList {
    public static ArrayList<StatusEffect> playerStatusEffects = new ArrayList<>();

    public static void restClearAllStats(){
        playerStatusEffects.clear(); // use clear because it has lower time complexity than removeall()
        System.out.println(playerStatusEffects.size()); // check that it is empty
    }

    public static void getAllEffectsFromSaveData() {

        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT rowid, * FROM playerStatusEffects WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet statsResultset = statement.executeQuery(sql);

            // save each result to the array
            while (statsResultset.next()) {
                StatusEffect statusEffect = new StatusEffect();
                int id = statsResultset.getInt("rowid");
                statusEffect.setEffectTitle(statsResultset.getString("effectTitle"));
                statusEffect.setHpPerTurn(statsResultset.getInt("hpPerTurn"));
                statusEffect.setMpPerTurn(statsResultset.getInt("mpPerTurn"));
                statusEffect.setTurnsLeft(statsResultset.getInt("turnsLeft"));
                statusEffect.setFlyingAtkBoost(statsResultset.getInt("flyingAtkBoost"));
                statusEffect.setShieldingAtkBoost(statsResultset.getInt("shieldingAtkBoost"));
                statusEffect.setPhasingAtkBoost(statsResultset.getInt("phasingAtkBoost"));

                playerStatusEffects.add(statusEffect);

                System.out.println(id + " Effect: " + statusEffect.getEffectTitle() +
                        ", hpPerTurn: " + statusEffect.getHpPerTurn() +
                        ", mpPerTurn: " + statusEffect.getMpPerTurn() +
                        ", turnsLeft: " + statusEffect.getTurnsLeft()
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }

    public static void saveCurrentStats(){
        // sql query to drop all existing stats in table with player name
        // sql query to insert player new stats one by one from the array
    }

}
