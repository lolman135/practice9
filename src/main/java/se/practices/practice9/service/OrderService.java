package se.practices.practice9.service;

import se.practices.practice9.model.Order;

import java.util.List;

import java.util.List;

/**
 * Service interface for managing customer orders.
 */
public interface OrderService {

    /**
     * Retrieves a list of all orders.
     *
     * @return a list of all Order objects
     */
    List<Order> getAllOrders();

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order
     * @return the Order with the specified ID, or null if not found
     */
    Order getOrderById(int id);

    /**
     * Saves or updates an order.
     *
     * @param order the Order object to save or update
     */
    void saveOrder(Order order);

    /**
     * Deletes an order by its ID.
     *
     * @param id the ID of the order to delete
     */
    void deleteOrder(int id);
}