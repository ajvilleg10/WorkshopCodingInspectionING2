package dinnerExperience;

import java.util.Scanner;

@SuppressWarnings("PMD.UseUtilityClass")
public class DiningExperienceManager {
    private static final int MAX_ORDER_QUANTITY = 100;

    public static void main(String[] args) {
    	
        try ( Scanner scanner = new Scanner(System.in)) {
            Meal[] menu = {
                new Meal("Spaghetti", 8.0),
                new Meal("Pizza", 10.0),
                new Meal("Sweet and Sour Chicken", 9.0),
                new Meal("Spring Rolls", 6.0),
                new Meal("Tiramisu", 5.0),
                new Meal("Cheesecake", 5.5),
                new Meal("Chef's Special Soup", 7.5),
                new Meal("Chef's Special Pasta", 12.0)
            };

            MenuManager menuManager = new MenuManager(menu);
            menuManager.displayMenu();

            System.out.println("Enter the quantity for each meal (0 to skip):");
            int[] quantities = getQuantities(menu.length, scanner);

            OrderManager orderManager = new OrderManager();
            Order order = orderManager.createOrder(quantities,menuManager.getMenu());

            double totalCost = order.calculateTotalCost();

            OrderConfirmationManager confirmationManager = new OrderConfirmationManager();
            if (confirmationManager.confirmOrder(order, totalCost, scanner)) {
                System.out.println("Order confirmed. Total Cost: $" + (int) totalCost);
            } else {
                System.out.println("Order canceled.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static int[] getQuantities(int menuSize, Scanner scanner) {
        int[] quantities = new int[menuSize];
        boolean validInput = false;

        do {
            try {
                for (int i = 0; i < menuSize; i++) {
                    System.out.print("Enter quantity for item " + (i + 1) + ": ");
                    quantities[i] = Integer.parseInt(scanner.nextLine());
                    if (quantities[i] < 1 || quantities[i] > DiningExperienceManager.MAX_ORDER_QUANTITY) {
                        throw new IllegalArgumentException("Invalid quantity. Please enter a number between 1 and "
                                + DiningExperienceManager.MAX_ORDER_QUANTITY + ".");
                    }
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid quantity.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!validInput);

        return quantities;
    }

}
