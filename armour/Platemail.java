package armour;

public class Platemail extends Armour {
    private final int protectionAmount = 60; // 60% damage reduction
    private final int dexCost = 65;           // dexterity cost

    public Platemail() {
        super("Platemail");
        setProtectionAmount(protectionAmount);
        setDexCost(dexCost);
    }
}