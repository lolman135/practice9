package se.practices.practice9.controller;

import org.aspectj.weaver.ast.Or;
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

    @GetMapping("/orders/admins")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "admins-info";
    }

    @PostMapping("/orders/admins/update-status")
    public String updateOrderStatus(
            @RequestParam int orderId,
            @RequestParam OrderStatus orderStatus
    ){
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(orderStatus);
            orderService.saveOrder(order);
        }
        return "redirect:/catalina_restaurant/orders/admins";
    }

    @PostMapping("/orders/admins/delete")
    public String deleteCanceledOrders(){
        List<Order> orders = orderService.getAllOrders();
        orders.forEach(order -> {
            if (order.getOrderStatus() == OrderStatus.CANCELED || order.getOrderStatus() == OrderStatus.DELIVERED){
                orderService.deleteOrder(order.getId());
            }
        });
        return "redirect:/catalina_restaurant/orders/admins";
    }
}
