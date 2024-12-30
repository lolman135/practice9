package se.practices.practice9.service;

import se.practices.practice9.model.MenuItem;
import se.practices.practice9.repository.MenuRepository;

import java.util.List;

public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMenuItem(MenuItem menuItem) {
        menuRepository.save(menuItem);
    }

    @Override
    public void deleteMenuItem(int id) {
        menuRepository.deleteById(id);
    }
}
