package utility;

import java.util.Scanner;

public class Validator {
    private final Scanner input = new Scanner(System.in);

    // Constructor
    public Validator() {}

    public int validatePick(int maxVal) {
        int choice = 0;
        while (true) {
            System.out.printf("Enter a number between 1 and %d:%n", maxVal);
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice >= 1 && choice <= maxVal) {
                    System.out.println("You entered: " + choice);
                    break;
                } else {
                    System.out.printf("Invalid number. Please enter from 1 to %d%n", maxVal);
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Please try again.");
            }
        }
        return choice;
    }

    public int validateAttackPick(int maxVal) {
        return validatePick(maxVal);
    }
}