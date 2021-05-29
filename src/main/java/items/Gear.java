package main.java.items;

// Gear the player has equipped
public class Gear {

    private String helmet;
    private String body;
    private String shield;
    private String boots;

    private String weapon;
    private String weapon2;

    public Gear(){

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
