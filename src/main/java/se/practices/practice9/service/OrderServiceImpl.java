package se.practices.practice9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.practices.practice9.model.Order;
import se.practices.practice9.repository.OrderRepository;

import java.util.List;

/**
 * Service implementation for managing orders.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Retrieves all orders sorted by ID in ascending order.
     * @return List of all orders.
     */
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Retrieves an order by its ID.
     * @param id Order ID.
     * @return The order if found, otherwise null.
     */
    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Saves a new order after validating the phone number.
     * @param order Order to save.
     * @throws IllegalArgumentException If the phone number is invalid.
     */
    @Override
    public void saveOrder(Order order) throws IllegalArgumentException {
        validatePhoneNumber(order.getCustomerPhone());
        orderRepository.save(order);
    }

    /**
     * Deletes an order by its ID.
     * @param id Order ID.
     */
    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    /**
     * Validates the phone number format (+380XXXXXXXXX).
     * @param phoneNumber Customer's phone number.
     * @throws IllegalArgumentException If the phone number is invalid.
     */
    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\+380[0-9]{9}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
}