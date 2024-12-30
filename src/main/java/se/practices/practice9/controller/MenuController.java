package se.practices.practice9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.practices.practice9.service.MenuService;

@Controller
@RequestMapping("/catalina_restaurant")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public String showMenu(Model model){
        model.addAttribute("menuItems", menuService.getAllMenuItems());
        return "menu-page";
    }
}
