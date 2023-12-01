package com.nyoba.nyicilprojek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sekretaris")
public class SecretaryController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isLogin",true);
        return "secretary/index";
    }
}