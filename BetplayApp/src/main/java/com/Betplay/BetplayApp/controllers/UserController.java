package com.Betplay.BetplayApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Betplay.BetplayApp.models.User;

@Controller
public class UserController {

    @GetMapping("/v2/details")
    public String details(Model model){
        User user = new User("Tribilin", "Spark");
        model.addAttribute("title", "Desarrollando con Spring boot");
        model.addAttribute("user", user);
        return "details";
    }
}