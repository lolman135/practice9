package se.practices.practice9.service;

import se.practices.practice9.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    void saveOrder(Order order);
    void deleteOrder(int id);
}
