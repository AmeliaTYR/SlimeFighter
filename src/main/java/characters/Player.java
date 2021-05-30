package main.java.characters;

import main.java.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static main.java.constants.SQLiteDB.jdbcURL;

public class Player {
    private String username;

    private int hp = 10;
    private int mp = 6;
    // max hp is 10 + (level - 1) * 3
    private int maxHp = 10;
    // max mp is 6 + (level - 1) * 2
    private int maxMp = 6;

    private int level = 1;
    private int exp = 0;
    private int coins = 0;

    private int flyingAtk = 1;
    private int shieldingAtk = 1;
    private int phasingAtk = 1;
    private int def = 7;

    // limit is 10 + level
    private int inventoryLimit = 10;

    public Player() {

    }

    public void setPlayerData(String username,
                              int hp, int mp,
                              int level, int exp, int coins,
                              int flyingAtk, int shieldingAtk, int phasingAtk,
                              int def) {
        this.username = username;
        this.hp = hp;
        this.mp = mp;
        this.level = level;
        this.exp = exp;
        this.coins = coins;
        this.flyingAtk = flyingAtk;
        this.shieldingAtk = shieldingAtk;
        this.phasingAtk = phasingAtk;
        this.def = def;

        this.maxHp = 10 + (level - 1) * 3;
        this.maxMp = 6 + (level - 1) * 2;
        this.inventoryLimit = 10 + this.level;
    }

    public void savePlayerDataToDB(){
        // sql query to update player info
        try {
            // make the sql query
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "UPDATE players SET " +
                    "hp = " + this.hp + ", " +
                    "mp = " + this.mp + ", " +
                    "level = " + this.level + ", " +
                    "Exp = " + this.exp + ", " +
                    "coins = " + this.coins + ", " +
                    "flyingAtk = " + this.flyingAtk + ", " +
                    "shieldingAtk = " + this.shieldingAtk + ", " +
                    "phasingAtk = " + this.phasingAtk + ", " +
                    "def = " + this.def + " " +
                    "WHERE userName = '" + Main.currentUser.getUsername() + "'";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            int updated = statement.executeUpdate(sql);

            if (updated == 1){
                System.out.println("profile update successful");
            }

            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("cannot connect to database");
        }

    }

    /**
     * Getters and setters below
     */

    public int getInventoryLimit() {
        return inventoryLimit;
    }

    public void setInventoryLimit(int inventoryLimit) {
        this.inventoryLimit = inventoryLimit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getFlyingAtk() {
        return flyingAtk;
    }

    public void setFlyingAtk(int flyingAtk) {
        this.flyingAtk = flyingAtk;
    }

    public int getShieldingAtk() {
        return shieldingAtk;
    }

    public void setShieldingAtk(int shieldingAtk) {
        this.shieldingAtk = shieldingAtk;
    }

    public int getPhasingAtk() {
        return phasingAtk;
    }

    public void setPhasingAtk(int phasingAtk) {
        this.phasingAtk = phasingAtk;
    }
}
