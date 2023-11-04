/**
 * 
 */
package dinnerExperience;

import java.util.Scanner;

/**
 * 
 */

public class OrderConfirmationManager {
	public boolean confirmOrder(Order order, double totalCost, Scanner scanner) {
        while (true) {
            try {
                System.out.println("Order Summary:");
                for (Meal meal : order.getItems().keySet()) {
                    int quantity = order.getItems().get(meal);
                    System.out.println(meal.getName() + " x " + quantity + " - $" + meal.getPrice() * quantity);
                }
                System.out.println("Total Cost: $" + totalCost);

                System.out.println("Do you want to confirm the order? (Y/N):");
                String choice = scanner.next().toUpperCase();
                if ("Y".equals(choice)) {
                    return true;
                } else if ("N".equals(choice)) {
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter 'Y' to confirm or 'N' to cancel.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while processing your order. Please try again.");
                scanner.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
    }
}
