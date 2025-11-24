package enemy;

import warrior.Orc;
import warrior.Warrior;
import weapon.WarHammer;
import weapon.Weapon;
import armour.Armour;
import armour.Chainmail;

public class Enemy {
    private final Warrior warrior;
    private final Weapon weapon;
    private final Armour armour;

    public Enemy() {
        this.warrior = new Orc();             // Always an Orc
        this.weapon = new WarHammer();        // Always a WarHammer
        this.armour = new Chainmail();        // Always Chainmail
    }

    public float attack(Warrior player, Armour playerArmour) {
        int attackType = (int)(Math.random() * 2) + 1;

        float damage = weapon.strike(
            attackType,
            warrior.getStrength(),
            warrior.getDexterity(),
            playerArmour.getDexCost()
        );

        damage *= (1 - playerArmour.getProtectionAmount() / 100.0f);

        return damage;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armour getArmour() {
        return armour;
    }
}