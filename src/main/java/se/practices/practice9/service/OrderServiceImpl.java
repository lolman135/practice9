package se.practices.practice9.service;

import se.practices.practice9.model.Order;
import se.practices.practice9.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrder(Order order) throws IllegalArgumentException {
        validatePhoneNumber(order.getCustomerPhone());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    private void validatePhoneNumber(String phoneNumber){
        if (!phoneNumber.matches("\\+380[0-9]{9}")){
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
