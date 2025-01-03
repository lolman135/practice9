package se.practices.practice9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling requests to the Catalina Restaurant home page.
 */
@Controller
@RequestMapping("/catalina_restaurant")
public class HomePageController {

    /**
     * Handles GET requests and returns the view name for the home page.
     *
     * @return the name of the home page view
     */
    @GetMapping
    public String showHomePage(){
        return "home-page";
    }
}
