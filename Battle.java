import utility.*;
import warrior.*;
import weapon.*;
import armour.*;
import enemy.*;

import java.util.Random;

public class Battle {
    private static final Ink ink = new Ink();
    private static final Validator validator = new Validator();
    private static final Random rand = new Random();

    private static Warrior player;
    private static Weapon pWeapon;
    private static Armour pArmour;

    private static Enemy enemy;

    private static boolean isPlayerTurn = true;
    private static boolean gameOver = false;
    private static float damage;

    public static void main(String[] args) {
        ink.welcome();
        setupGame();

        while (!gameOver) {
            if (isPlayerTurn) {
                ink.attackMenu();
                int attackChoice = validator.validateAttackPick(2); // 1 or 2

                damage = pWeapon.strike(
                    attackChoice,
                    player.getStrength(),
                    player.getDexterity(),
                    pArmour.getDexCost()
                );

                damage *= (1 - enemy.getArmour().getProtectionAmount() / 100.0f);

                if (damage > 0) {
                    enemy.getWarrior().reduceHealth(damage);
                    if (enemy.getWarrior().getHealth() <= 0) {
                        System.out.println("Player Wins!");
                        gameOver = true;
                    }
                }

                ink.attackResult(damage, enemy.getWarrior(), "Player");
                damage = 0;
            } else {
                damage = enemy.attack(player, pArmour);

                if (damage > 0) {
                    player.reduceHealth(damage);
                    if (player.getHealth() <= 0) {
                        System.out.println("Enemy Wins!");
                        gameOver = true;
                    }
                }

                ink.attackResult(damage, player, "Enemy");
                damage = 0;
            }

            isPlayerTurn = !isPlayerTurn;
        }

        ink.goodbye();
    }

    private static void setupGame() {
        ink.warriorMenu();
        int warriorChoice = validator.validatePick(3); // 1 to 3
        if (warriorChoice == 1) player = new Human();
        else if (warriorChoice == 2) player = new Elf();
        else player = new Hobbit();

        ink.weaponMenu();
        int weaponChoice = validator.validatePick(3);
        if (weaponChoice == 1) pWeapon = new Dagger();
        else if (weaponChoice == 2) pWeapon = new Sword();
        else pWeapon = new Axe();

        ink.armourMenu();
        int armourChoice = validator.validatePick(3);
        if (armourChoice == 1) pArmour = new Leather();
        else if (armourChoice == 2) pArmour = new Chainmail();
        else pArmour = new Platemail();

        enemy = new Enemy(); // always an Orc with fixed gear

        ink.printStats(player, pWeapon, pArmour, enemy.getWarrior(), enemy.getWeapon(), enemy.getArmour());
    }
}