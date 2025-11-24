package weapon;

public class Axe extends Weapon {
    private final int baseDamage = 90;
    private final int dexCost = 50;
    private final int hitChance = 40;

    public Axe() {
        super("Axe");
        setBaseDamage(baseDamage);
        setDexCost(dexCost);
    }

    @Override
    public int strike(int attackType, int strength, int dexterity, int aDexCost) {
        int damageAmount = 0;
        int roll = randNum.nextInt(100) + 1;

        roll += attackType * 5;
        roll -= dexterity / 10;
        roll += aDexCost / 10;

        if (roll <= hitChance) {
            damageAmount = baseDamage + randNum.nextInt(strength / 5 + 1);
        }

        return damageAmount;
    }
}