package se.practices.practice9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.practices.practice9.service.MenuService;

/**
 * Controller for managing requests related to the menu of the Catalina Restaurant.
 */
@Controller
@RequestMapping("/catalina_restaurant")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * Handles GET requests for the menu page, adds menu items to the model, and returns the view name.
     *
     * @param model the model to hold menu data
     * @return the name of the menu page view
     */
    @GetMapping("/menu")
    public String showMenu(Model model){
        model.addAttribute("menuItems", menuService.getAllMenuItems());
        return "menu-page";
    }
}
