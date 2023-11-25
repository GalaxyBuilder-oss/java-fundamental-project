package com.nyoba.nyicilprojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.models.Auth;
import com.nyoba.nyicilprojek.services.AuthService;

@Controller
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private AuthService authService;
    
    @GetMapping("/add")
    public String add(Model model) {
        return authService.add(model);
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(value = "add")Auth user) {
        return authService.save(user);
    }

}
