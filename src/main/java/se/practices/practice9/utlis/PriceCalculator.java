package se.practices.practice9.utlis;

import se.practices.practice9.service.MenuService;

import java.util.List;
import java.util.stream.Stream;

public class PriceCalculator {

    public static double calculateTotalPrice(String menuItems, String quantities, MenuService menuService){
        List<String> menuItemsList = List.of(menuItems.split(", "));
        List<Integer> qtyList = Stream.of(quantities.split(", ")).map(Integer::parseInt).toList();
        double total = 0;

        for (int i = 0; i < menuItemsList.size(); i++) {
            String menuItemId = menuItemsList.get(i);
            int quantity = qtyList.get(i);
            double price = menuService.getMenuItemByName(menuItemId).getPrice();
            total += price * quantity;
        }

        return total;
    }
}
