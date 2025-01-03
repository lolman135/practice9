package se.practices.practice9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalina_restaurant")
public class HomePageController {

    @GetMapping
    public String showHomePage(){
        return "home-page";
    }
}
