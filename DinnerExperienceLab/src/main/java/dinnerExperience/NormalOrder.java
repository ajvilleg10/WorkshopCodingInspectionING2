package dinnerExperience;

public class NormalOrder extends Order {
    @Override
    public double calculateTotalCost() {
        double totalCost = getBaseCost(); // Obtiene el base_cost utilizando el método protegido
        for (Meal meal : getItems().keySet()) {
            int quantity = getItems().get(meal);
            totalCost += meal.getPrice() * quantity;
        }
        return totalCost;
    }
}
