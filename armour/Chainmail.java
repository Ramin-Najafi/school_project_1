package armour;

public class Chainmail extends Armour {
    private final int protectionAmount = 40; // 40% damage reduction
    private final int dexCost = 35;           // dexterity cost

    public Chainmail() {
        super("Chainmail");
        setProtectionAmount(protectionAmount);
        setDexCost(dexCost);
    }
}