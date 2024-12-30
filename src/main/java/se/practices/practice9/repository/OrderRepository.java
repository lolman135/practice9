package se.practices.practice9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.practices.practice9.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
