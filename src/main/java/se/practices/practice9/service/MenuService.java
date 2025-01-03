package se.practices.practice9.service;

import se.practices.practice9.model.MenuItem;

import java.util.List;

/**
 * Service interface for managing menu items.
 */
public interface MenuService {

    /**
     * Retrieves a list of all menu items.
     *
     * @return a list of all MenuItem objects
     */
    List<MenuItem> getAllMenuItems();

    /**
     * Retrieves a menu item by its ID.
     *
     * @param id the ID of the menu item
     * @return the MenuItem with the specified ID, or null if not found
     */
    MenuItem getMenuItemById(int id);

    /**
     * Retrieves a menu item by its name.
     *
     * @param name the name of the menu item
     * @return the MenuItem with the specified name, or null if not found
     */
    MenuItem getMenuItemByName(String name);

    /**
     * Saves or updates a menu item.
     *
     * @param menuItem the MenuItem object to save or update
     */
    void saveMenuItem(MenuItem menuItem);

    /**
     * Deletes a menu item by its ID.
     *
     * @param id the ID of the menu item to delete
     */
    void deleteMenuItem(int id);
}