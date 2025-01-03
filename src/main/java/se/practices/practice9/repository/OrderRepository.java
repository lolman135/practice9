package se.practices.practice9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.practices.practice9.model.Order;

/**
 * Repository interface for performing CRUD operations on Order entities.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
