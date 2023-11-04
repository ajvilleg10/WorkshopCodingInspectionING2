/**
 * 
 */
package dinnerExperience;

/**
 * 
 */
public class MenuManager {
    private Meal[] menu;

    public MenuManager(Meal... menu) {
        this.menu = menu.clone();
    }

    public void displayMenu() {
        System.out.println("Menu Options:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getName() + " - $" + menu[i].getPrice());
        }
    }

    public Meal[] getMenu() {
    	return menu == null ? null : menu.clone();
    }
}

