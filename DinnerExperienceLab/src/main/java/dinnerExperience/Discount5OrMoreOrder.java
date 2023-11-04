package dinnerExperience;

public class Discount5OrMoreOrder extends Order {
    private static final double DISCOUNT_RATE = 0.1; // 10% discount for orders with 5 or more items

    @Override
    public double calculateTotalCost() {
        double totalCost = getBaseCost(); // Obtiene el base_cost utilizando el método protegido
        for (Meal meal : getItems().keySet()) {
            int quantity = getItems().get(meal);
            totalCost += meal.getPrice() * quantity;
        }

        int totalQuantity = getTotalQuantity();
        if (totalQuantity >= 5) {
            totalCost *= (1 - DISCOUNT_RATE);
        }
        return totalCost;
    }
}
