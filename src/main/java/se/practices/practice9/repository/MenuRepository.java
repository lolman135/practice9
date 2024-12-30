package se.practices.practice9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.practices.practice9.model.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Integer> {
}
