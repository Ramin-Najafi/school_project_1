package utility;

import warrior.*;
import weapon.*;
import armour.*;

public class Ink {
    // ANSI escape codes
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    public Ink() {} // constructor

    public void welcome() {
        System.out.println("///////////////////////////////////");
        System.out.println("///// Welcome to Warsim 2025! /////");
        System.out.println("///////////////////////////////////\n");
    }

    public void goodbye() {
        System.out.println("\n///////////////////////////////////");
        System.out.println("///// Thank you for playing!! /////");
        System.out.println("///////////////////////////////////\n");
    }

    public void warriorMenu() {
        System.out.println("/////////////////////////////");
        System.out.println("/// Choose your warrior: ");
        System.out.println("/// 1) Human");
        System.out.println("/// 2) Elf");
        System.out.println("/// 3) Hobbit");
        System.out.println("/////////////////////////////\n");
    }

    public void weaponMenu() {
        System.out.println("/////////////////////////////");
        System.out.println("/// Choose your weapon: ");
        System.out.println("/// 1) Dagger");
        System.out.println("/// 2) Sword");
        System.out.println("/// 3) Axe");
        System.out.println("/////////////////////////////\n");
    }

    public void armourMenu() {
        System.out.println("/////////////////////////////");
        System.out.println("/// Choose your armour: ");
        System.out.println("/// 1) Leather");
        System.out.println("/// 2) Chainmail");
        System.out.println("/// 3) Platemail");
        System.out.println("/////////////////////////////\n");
    }

    public void attackMenu() {
        System.out.println("/////////////////////////////");
        System.out.println("/// Select your attack: ");
        System.out.println("/// 1) Normal");
        System.out.println("/// 2) Heavy");
        System.out.println("/////////////////////////////\n");
    }

    public void attackResult(float damage, Warrior target, String attackerName) {
        System.out.printf(attackerName + " dealt %.2f damage!%n", damage);
        System.out.printf(target.getType() + " has %.2f health remaining.%n\n", (float)target.getHealth());
    }

    public void printStats(Warrior player, Weapon pWeapon, Armour pArmour,
                           Warrior enemy, Weapon eWeapon, Armour eArmour) {
        System.out.println("/////////////////////////////");
        System.out.printf("/// %s(%s) Stats:%n", "Player", player.getType());
        System.out.printf("/// " + BLUE + "Armour:    %s%n" + RESET, pArmour.getType());
        System.out.printf("/// Weapon:    %s%n", pWeapon.getType());
        System.out.printf("/// Health:    %12d%n", player.getHealth());
        System.out.printf("/// Strength:  %12d%n", player.getStrength());
        System.out.printf("/// Dexterity: %12d%n", player.getDexterity());

        System.out.println("\n/////////////////////////////");
        System.out.printf("/// %s(%s) Stats:%n", "Enemy", enemy.getType());
        System.out.printf("/// " + RED + "Armour:    %s%n" + RESET, eArmour.getType());
        System.out.printf("/// Weapon:    %s%n", eWeapon.getType());
        System.out.printf("/// Health:    %12d%n", enemy.getHealth());
        System.out.printf("/// Strength:  %12d%n", enemy.getStrength());
        System.out.printf("/// Dexterity: %12d%n", enemy.getDexterity());
        System.out.println("/////////////////////////////\n");
    }
}