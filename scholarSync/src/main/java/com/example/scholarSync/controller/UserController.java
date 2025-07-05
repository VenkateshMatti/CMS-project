  package com.example.scholarSync.controller;

import com.example.scholarSync.Model.User;
import com.example.scholarSync.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser (User user) {
        userService.registerUser (user);
        return "redirect:/login";
    }

    @GetMapping("/user-home")
    public String home() {
        return "home";
    }
}
