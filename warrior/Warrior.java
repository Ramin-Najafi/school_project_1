package warrior;

import java.util.Random;

public abstract class Warrior {
    private final String type;
    private int health;
    private int strength;
    private int dexterity;

    protected Random randNum = new Random();

    public Warrior(String type) {
        this.type = type;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    // Setters
    public void setHealth(int h) {
        health = h;
    }

    public void setStrength(int s) {
        strength = s;
    }

    public void setDexterity(int d) {
        dexterity = d;
    }

    // Take damage
    public void reduceHealth(float damage) {
        health -= (int) damage;
    }
}