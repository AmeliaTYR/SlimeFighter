package main.java.characters;

public class Player {
    private String username;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;
    private int exp;
    private int level;
    private int coins;
    private int flyingAtk;
    private int shieldingAtk;
    private int phasingAtk;
    private int def;


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
