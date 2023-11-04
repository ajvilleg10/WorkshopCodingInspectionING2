/**
 * 
 */
package dinnerExperience;

/**
 * 
 */
@SuppressWarnings("PMD.UseUtilityClass")
public class SpecialDiscounts {
    private static final double SPECIAL_OFFER_DISCOUNT_50 = 10.0;
    private static final double SPECIAL_OFFER_DISCOUNT_100 = 25.0;

    public static double applySpecialOfferDiscount(double totalCost) {
        double discountedCost = totalCost; // Create a separate variable to store the discounted value

        if (totalCost > 100) {
            discountedCost -= SPECIAL_OFFER_DISCOUNT_100;
        } else if (totalCost > 50) {
            discountedCost -= SPECIAL_OFFER_DISCOUNT_50;
        }

        return discountedCost; // Return the discounted value without modifying the original parameter
    }


}
