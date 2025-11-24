package armour;

public abstract class Armour {
    private String type;
    private int protectionAmount;
    private int dexCost;

    public Armour(String type) {
        this.type = type;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getProtectionAmount() {
        return protectionAmount;
    }

    public int getDexCost() {
        return dexCost;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setProtectionAmount(int protectionAmount) {
        this.protectionAmount = protectionAmount;
    }

    public void setDexCost(int dexCost) {
        this.dexCost = dexCost;
    }
}