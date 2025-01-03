package se.practices.practice9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.practices.practice9.model.Order;
import se.practices.practice9.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
