package dinnerExperience;

import java.util.Map;
import java.util.HashMap;

abstract class Order {
	private static final double BASE_COST = 5.0; // Base cost for every order
    private Map<Meal, Integer> items = new HashMap<>();

    protected void addItem(Meal meal, int quantity) {
        items.put(meal, quantity);
    }

    protected Map<Meal, Integer> getItems() {
        return items;
    }

    // Calculate the total cost for the order based on the chosen strategy
    public abstract double calculateTotalCost();

    // Calculate the total quantity of meals ordered
    protected int getTotalQuantity() {
        return getItems().values().stream().mapToInt(Integer::intValue).sum();
    }
    
	// Get the base cost for the order (accessible within the package and subclasses)
    protected static double getBaseCost() {
        return BASE_COST;
    }
}
