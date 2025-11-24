package armour;

public class Leather extends Armour {
    private final int protectionAmount = 20; // 20% damage reduction
    private final int dexCost = 5;            // dexterity cost

    public Leather() {
        super("Leather");
        setProtectionAmount(protectionAmount);
        setDexCost(dexCost);
    }
}