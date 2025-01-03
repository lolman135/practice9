package se.practices.practice9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.practices.practice9.model.Order;
import se.practices.practice9.model.OrderStatus;
import se.practices.practice9.service.MenuService;
import se.practices.practice9.service.OrderService;
import se.practices.practice9.utlis.PriceCalculator;

import java.time.LocalTime;
import java.util.List;

/**
 * Controller for managing orders in the Catalina Restaurant.
 */
@Controller
@RequestMapping("/catalina_restaurant")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuService menuService;

    /**
     * Displays the order form.
     * @param model Model to pass menu items to the view.
     * @return The order registration view.
     */
    @GetMapping("/orders/new")
    public String showOrderForm(Model model) {
        model.addAttribute("menuItems", menuService.getAllMenuItems());
        return "order-registration";
    }

    /**
     * Registers a new order.
     * @param customerName Customer's name.
     * @param customerPhone Customer's phone number.
     * @param customerAddress Customer's address.
     * @param menuItems Ordered menu items.
     * @param quantities Quantities of menu items.
     * @return Redirects to the success page.
     */
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

    /**
     * Displays the order success page.
     * @return The success page view.
     */
    @GetMapping("/orders/success")
    public String orderSuccess() {
        return "order-success";
    }

    /**
     * Displays all orders for administrators.
     * @param model Model to pass orders to the view.
     * @return The admin orders view.
     */
    @GetMapping("/orders/admins")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "admins-info";
    }

    /**
     * Updates the status of an order.
     * @param orderId ID of the order to update.
     * @param orderStatus New status of the order.
     * @return Redirects to the admin orders page.
     */
    @PostMapping("/orders/admins/update-status")
    public String updateOrderStatus(
            @RequestParam int orderId,
            @RequestParam OrderStatus orderStatus
    ) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(orderStatus);
            orderService.saveOrder(order);
        }
        return "redirect:/catalina_restaurant/orders/admins";
    }

    /**
     * Deletes orders with statuses CANCELED or DELIVERED.
     * @return Redirects to the admin orders page.
     */
    @PostMapping("/orders/admins/delete")
    public String deleteCanceledAndDeliveredOrders() {
        List<Order> orders = orderService.getAllOrders();
        orders.forEach(order -> {
            if (order.getOrderStatus() == OrderStatus.CANCELED || order.getOrderStatus() == OrderStatus.DELIVERED) {
                orderService.deleteOrder(order.getId());
            }
        });
        return "redirect:/catalina_restaurant/orders/admins";
    }
}
