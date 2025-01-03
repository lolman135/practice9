package se.practices.practice9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.practices.practice9.model.MenuItem;

/**
 * Repository interface for performing CRUD operations on MenuItem entities.
 */
public interface MenuRepository extends JpaRepository<MenuItem, Integer> {

    /**
     * Retrieves a MenuItem by its name.
     *
     * @param name the name of the menu item
     * @return the MenuItem with the specified name, or null if not found
     */
    MenuItem getMenuItemByName(String name);
}