package com.nyoba.nyicilprojek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.config.AuthConfig;
import com.nyoba.nyicilprojek.models.Auth;

@Controller
@RequestMapping("/auth")
public class AuthController extends AuthConfig {
    
    @GetMapping("/add/")
    public String add(Model model) {
        return authService.add(model);
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(value = "add")Auth user,Model model) {
        return authService.save(user,model);
    }

}
