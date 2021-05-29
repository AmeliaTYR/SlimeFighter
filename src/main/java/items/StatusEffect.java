package main.java.items;

public class StatusEffect {

    private String effectTitle;
    private int hpPerTurn;
    private int mpPerTurn;
    private int turnsLeft;
    private int flyingAtkBoost;
    private int shieldingAtkBoost;
    private int phasingAtkBoost;

    public String getEffectTitle() {
        return effectTitle;
    }

    public void setEffectTitle(String effectTitle) {
        this.effectTitle = effectTitle;
    }

    public int getHpPerTurn() {
        return hpPerTurn;
    }

    public void setHpPerTurn(int hpPerTurn) {
        this.hpPerTurn = hpPerTurn;
    }

    public int getMpPerTurn() {
        return mpPerTurn;
    }

    public void setMpPerTurn(int mpPerTurn) {
        this.mpPerTurn = mpPerTurn;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }

    public int getFlyingAtkBoost() {
        return flyingAtkBoost;
    }

    public void setFlyingAtkBoost(int flyingAtkBoost) {
        this.flyingAtkBoost = flyingAtkBoost;
    }

    public int getShieldingAtkBoost() {
        return shieldingAtkBoost;
    }

    public void setShieldingAtkBoost(int shieldingAtkBoost) {
        this.shieldingAtkBoost = shieldingAtkBoost;
    }

    public int getPhasingAtkBoost() {
        return phasingAtkBoost;
    }

    public void setPhasingAtkBoost(int phasingAtkBoost) {
        this.phasingAtkBoost = phasingAtkBoost;
    }
}
