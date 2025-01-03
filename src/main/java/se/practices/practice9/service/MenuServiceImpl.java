package se.practices.practice9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.practices.practice9.model.MenuItem;
import se.practices.practice9.repository.MenuRepository;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;


    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public MenuItem getMenuItemById(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem getMenuItemByName(String name) {
        return menuRepository.getMenuItemByName(name);
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
