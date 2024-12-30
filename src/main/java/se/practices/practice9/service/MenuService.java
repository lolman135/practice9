package se.practices.practice9.service;

import se.practices.practice9.model.MenuItem;

import java.util.List;

public interface MenuService {
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(int id);
    void saveMenuItem(MenuItem menuItem);
    void deleteMenuItem(int id);
}
