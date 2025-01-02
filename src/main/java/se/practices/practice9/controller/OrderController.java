package se.practices.practice9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.practices.practice9.model.Order;
import se.practices.practice9.model.OrderStatus;
import se.practices.practice9.service.MenuService;
import se.practices.practice9.service.OrderService;
import se.practices.practice9.utlis.PriceCalculator;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/catalina_restaurant")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private  MenuService menuService;


    @GetMapping("/orders/new")
    public String showOrderForm(Model model) {
        model.addAttribute("menuItems", menuService.getAllMenuItems());
        return "order-registration";
    }

    @PostMapping("/orders/register")
    public String registerOrder(
            @RequestParam String customerName,
            @RequestParam String customerPhone,
            @RequestParam String customerAddress,
            @RequestParam String menuItems,
            @RequestParam String quantities
    ) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerPhone(customerPhone);
        order.setCustomerAddress(customerAddress);
        order.setOrderStatus(OrderStatus.PENDING);
        order.setMenuItems(menuItems);
        order.setQuantities(quantities);
        order.setTotalPrice(PriceCalculator.calculateTotalPrice(menuItems, quantities, menuService));
        order.setCreatedAt(LocalTime.now());

        orderService.saveOrder(order);

        return "redirect:/catalina_restaurant/orders/success";
    }

    @GetMapping("/orders/success")
    public String orderSuccess() {
        return "order-success";
    }

}
