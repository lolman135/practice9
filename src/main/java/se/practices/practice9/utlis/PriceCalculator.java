package se.practices.practice9.utlis;

import se.practices.practice9.service.MenuService;

import java.util.List;
import java.util.stream.Stream;

/**
 * Utility class for calculating the total price of an order.
 */
public class PriceCalculator {

    /**
     * Calculates the total price of an order based on menu items and their quantities.
     *
     * @param menuItems Comma-separated names of the menu items.
     * @param quantities Comma-separated quantities corresponding to the menu items.
     * @param menuService Service to fetch menu item details.
     * @return The total price of the order.
     */
    public static double calculateTotalPrice(String menuItems, String quantities, MenuService menuService) {
        List<String> menuItemsList = List.of(menuItems.split(", "));
        List<Integer> qtyList = Stream.of(quantities.split(", ")).map(Integer::parseInt).toList();
        double total = 0;

        for (int i = 0; i < menuItemsList.size(); i++) {
            String menuItemName = menuItemsList.get(i);
            int quantity = qtyList.get(i);
            double price = menuService.getMenuItemByName(menuItemName).getPrice();
            total += price * quantity;
        }

        return total;
    }
}
