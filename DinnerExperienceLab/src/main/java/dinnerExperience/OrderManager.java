/**
 * 
 */
package dinnerExperience;

/**
 * 
 */
public class OrderManager {
    private static final int MAX_ORDER_QUANTITY = 100;

    public Order createOrder(int[] quantities, Meal... menu) {
        Order order = new NormalOrder();

        try {
            if (menu == null || quantities == null) {
                throw new NullPointerException("Menu and quantities must not be null.");
            }

            for (int i = 0; i < menu.length; i++) {
                if (menu[i] == null) {
                    throw new IllegalArgumentException("Menu contains a null item at index: " + i);
                }

                if (quantities[i] > 0) {
                    if (quantities[i] > MAX_ORDER_QUANTITY) {
                        throw new IllegalArgumentException("Maximum order quantity for " + menu[i].getName() + " is " + MAX_ORDER_QUANTITY + ".");
                    }
                    order.addItem(menu[i], quantities[i]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            // Puedes decidir cómo manejar la excepción aquí, como asignar un valor predeterminado a order o mostrar un mensaje de error al usuario.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Puedes decidir cómo manejar la excepción aquí, como asignar un valor predeterminado a order o mostrar un mensaje de error al usuario.
        }

        return order;
    }
}
