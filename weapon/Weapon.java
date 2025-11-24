package weapon;

import java.util.Random;

public abstract class Weapon {
    private String type;
    private int baseDamage;
    private int dexCost;

    protected Random randNum = new Random();

    public Weapon(String type) {
        this.type = type;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getDexCost() {
        return dexCost;
    }

    public abstract int strike(int attackType, int strength, int dexterity, int armorDexCost);

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setDexCost(int dexCost) {
        this.dexCost = dexCost;
    }
}