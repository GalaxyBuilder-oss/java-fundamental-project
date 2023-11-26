package com.nyoba.nyicilprojek.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyoba.nyicilprojek.config.AuthConfig;

@Controller
@RequestMapping("/user")
public class UserController extends AuthConfig {

    @GetMapping("/")
    public String home(Model model) {
        if(isUserLogin){
            model.addAttribute("isLogin",isUserLogin);
            return "user/index";
        }
        else if(isAdminLogin) return "redirect:/admin/";
        return "redirect:/login/";
    }
}
