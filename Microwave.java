import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program is for a microwave calculator that
 * calculates the time needed to heat 3 types of food
 * (food: sub, pizza, soup) the time is already set
 * (time: sub = 60 seconds, pizza = 45 seconds, soup = 105 seconds)
 * the program asks the user for the item, and then the quantity of it.
 * if its 2 items the time is increased by 50%
 * and if its 3 items the time is increased by 100%
 * it will then display the total time needed to heat the food.
 *
 * @author  Shem Irekpita
 * @version 1.0
 * @since   2026-22-09
 */
public final class Microwave {

    /**
     * Private constructor to satisfy Checkstyle utility class rule.
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method to run the microwave program.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner declaration

        // User inputs
        System.out.println("This program is to calculate"
                + " the microwave time");
        System.out.print("Please enter the item you want to reheat "
                + "(sub, pizza, soup): ");

        try {
            String inputChoice = sc.nextLine().trim().toLowerCase();
            int baseTime = 0;
            String itemName = "";
            boolean isValid = true;

            // Check strictly for food names
            if (inputChoice.equals("sub")) {
                baseTime = 60;
                itemName = "sub";
            } else if (inputChoice.equals("pizza")) {
                baseTime = 45;
                itemName = "pizza";
            } else if (inputChoice.equals("soup")) {
                baseTime = 105;
                itemName = "soup";
            } else {
                System.out.println("Error: Please enter a proper input.");
                isValid = false;
            }

            // Only proceed to item amount if user selected a valid item
            if (isValid) {
                System.out.print("Please enter how many items "
                        + "you wanna reheat (Max 3): ");
                int amount = sc.nextInt();

                double totalSeconds = 0;
                boolean isQuantityValid = true;

                if (amount == 1) {
                    totalSeconds = baseTime;
                } else if (amount == 2) {
                    totalSeconds = baseTime * 1.5;
                } else if (amount == 3) {
                    totalSeconds = baseTime * 2.0;
                } else {
                    System.out.println("Error: Quantity must be 1, 2, or 3.");
                    isQuantityValid = false;
                }

                // Calculations and Display
                if (isQuantityValid) {
                    long roundedSeconds = Math.round(totalSeconds);
                    long minutes = roundedSeconds / 60;
                    long seconds = roundedSeconds % 60;

                    System.out.println();
                    System.out.println("Total time: " + roundedSeconds
                            + " seconds (" + minutes + " min "
                            + seconds + " sec)");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid numeric value.");
        } finally {
            sc.close(); // closes the scanner
        }
    }
}
