package se.practices.practice9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.practices.practice9.model.MenuItem;
import se.practices.practice9.repository.MenuRepository;

import java.util.List;

/**
 * Implementation of the MenuService interface for managing menu items.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * Retrieves all menu items sorted by ID in ascending order.
     *
     * @return a list of all MenuItem objects
     */
    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Retrieves a menu item by its ID.
     *
     * @param id the ID of the menu item
     * @return the MenuItem with the specified ID, or null if not found
     */
    @Override
    public MenuItem getMenuItemById(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a menu item by its name.
     *
     * @param name the name of the menu item
     * @return the MenuItem with the specified name, or null if not found
     */
    @Override
    public MenuItem getMenuItemByName(String name) {
        return menuRepository.getMenuItemByName(name);
    }

    /**
     * Saves or updates a menu item.
     *
     * @param menuItem the MenuItem object to save or update
     */
    @Override
    public void saveMenuItem(MenuItem menuItem) {
        menuRepository.save(menuItem);
    }

    /**
     * Deletes a menu item by its ID.
     *
     * @param id the ID of the menu item to delete
     */
    @Override
    public void deleteMenuItem(int id) {
        menuRepository.deleteById(id);
    }
}